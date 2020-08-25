package com.arielsonsantos.sgco.dumplocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dumps")
public class DumpLocationController {

    @Autowired
    private DumpLocationService service;

    @GetMapping()
    public ResponseEntity<List<DumpLocation>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

}
