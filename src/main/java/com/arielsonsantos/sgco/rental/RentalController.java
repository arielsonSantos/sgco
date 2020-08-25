package com.arielsonsantos.sgco.rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rentals")
public class RentalController {

    @Autowired
    private RentalService service;

    @GetMapping()
    public ResponseEntity<List<Rental>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

}
