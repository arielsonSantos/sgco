package com.arielsonsantos.sgco.vehicle;

import com.arielsonsantos.sgco.exceptions.ObjectNotFoundException;
import com.arielsonsantos.sgco.rental.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    public Vehicle findById(Integer id) {
        Optional<Vehicle> vehicle = repository.findById(id);
        return vehicle.orElseThrow(() -> new ObjectNotFoundException("Veículo com id " + id + " não encontrado!"));
    }
}
