package com.arielsonsantos.sgco.containertype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/container-types")
public class ContainerTypeController {

    @Autowired
    private ContainerTypeService service;

    @GetMapping()
    public ResponseEntity<List<ContainerType>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
