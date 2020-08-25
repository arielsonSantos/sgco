package com.arielsonsantos.sgco.drivervehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverVehicleService {

    @Autowired
    private DriverVehicleRepository repository;

    public List<DriverVehicle> findAll() {
        return repository.findAll();
    }
}
