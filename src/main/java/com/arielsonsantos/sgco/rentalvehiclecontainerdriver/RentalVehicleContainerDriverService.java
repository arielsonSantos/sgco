package com.arielsonsantos.sgco.rentalvehiclecontainerdriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalVehicleContainerDriverService {

    @Autowired
    private RentalVehicleContainerDriverRepository repository;

    public List<RentalVehicleContainerDriver> findAll() {
        return repository.findAll();
    }
}
