package com.arielsonsantos.sgco.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping()
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Address> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
