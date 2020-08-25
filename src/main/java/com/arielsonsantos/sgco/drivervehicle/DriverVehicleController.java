package com.arielsonsantos.sgco.drivervehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/driver-vehicle")
public class DriverVehicleController {

    @Autowired
    private DriverVehicleService service;

    @GetMapping()
    public ResponseEntity<List<DriverVehicle>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

}
