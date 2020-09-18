package com.arielsonsantos.sgco.dumplocation;

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
@RequestMapping(value = "/dumps")
public class DumpLocationController {

    @Autowired
    private DumpLocationService service;

    @GetMapping()
    public ResponseEntity<List<DumpLocationListDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(DumpLocationListDTO::new).collect(Collectors.toList()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DumpLocationListDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(new DumpLocationListDTO(service.findById(id)));
    }

    @GetMapping(path = "/page")
    public ResponseEntity<Page<DumpLocation>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
        return ResponseEntity.ok().body(service.findPage(page, linesPerPage, orderBy, direction));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody DumpLocationDTO dumpLocationDTO) {
        DumpLocation newContainer = service.insert(new DumpLocation(dumpLocationDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newContainer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody DumpLocationDTO dumpLocationDTO, @PathVariable Integer id) {
        service.update(new DumpLocation(dumpLocationDTO), id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
