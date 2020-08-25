package com.arielsonsantos.sgco.rentalcontainers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rental-containers")
public class RentalContainersController {

    @Autowired
    private RentalContainersService service;

    @GetMapping()
    public ResponseEntity<List<RentalContainers>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

}
