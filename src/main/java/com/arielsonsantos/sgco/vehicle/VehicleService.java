package com.arielsonsantos.sgco.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    public List<Vehicle> saveAll(List<Vehicle> vehicles) {
        return repository.saveAll(vehicles);
    }
}
