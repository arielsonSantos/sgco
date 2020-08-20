package com.arielsonsantos.sgco.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping()
    public ResponseEntity<List<Vehicle>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
