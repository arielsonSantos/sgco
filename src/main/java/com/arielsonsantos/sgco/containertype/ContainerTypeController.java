package com.arielsonsantos.sgco.containertype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/container-types")
public class ContainerTypeController {

    @Autowired
    private ContainerTypeService service;

    @GetMapping()
    public ResponseEntity<List<ContainerTypeListDTO>> findAll() {
        List<ContainerType> containerTypes = service.findAll();
        List<ContainerTypeListDTO> containerTypeListDTO = containerTypes.stream().map(ContainerTypeListDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(containerTypeListDTO);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ContainerTypeListDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(new ContainerTypeListDTO(service.findById(id)));
    }

    @GetMapping(path = "/page")
    public ResponseEntity<Page<ContainerType>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
        return ResponseEntity.ok().body(service.findPage(page, linesPerPage, orderBy, direction));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ContainerTypeDTO containerTypeDTO) {
        ContainerType newContainer = service.insert(ContainerType.fromDTO(containerTypeDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newContainer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ContainerTypeDTO containerTypeDTO, @PathVariable Integer id) {
        service.update(ContainerType.fromDTO(containerTypeDTO), id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
