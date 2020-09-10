package com.arielsonsantos.sgco.container;

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
@RequestMapping(value = "/containers")
public class ContainerController {

    @Autowired
    private ContainerService service;

    @GetMapping()
    public ResponseEntity<List<ContainerListDTO>> findAll() {
        List<Container> containers = service.findAll();
        List<ContainerListDTO> containerListDTO = containers.stream().map(ContainerListDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(containerListDTO);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ContainerListDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(new ContainerListDTO(service.findById(id)));
    }

    @GetMapping(path = "/page")
    public ResponseEntity<Page<Container>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
        return ResponseEntity.ok().body(service.findPage(page, linesPerPage, orderBy, direction));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ContainerDTO containerDTO) {
        Container newContainer = service.insert(Container.fromDTO(containerDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newContainer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ContainerDTO containerDTO, @PathVariable Integer id) {
        service.update(Container.fromDTO(containerDTO), id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
