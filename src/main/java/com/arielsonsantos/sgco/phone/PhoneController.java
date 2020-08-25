package com.arielsonsantos.sgco.phone;

import com.arielsonsantos.sgco.rental.Rental;
import com.arielsonsantos.sgco.rental.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/phones")
public class PhoneController {

    @Autowired
    private PhoneService service;

    @GetMapping()
    public ResponseEntity<List<Phone>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

}
