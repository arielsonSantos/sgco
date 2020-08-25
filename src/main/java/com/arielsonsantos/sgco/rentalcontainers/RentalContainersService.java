package com.arielsonsantos.sgco.rentalcontainers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalContainersService {

    @Autowired
    private RentalContainersRepository repository;

    public List<RentalContainers> findAll() {
        return repository.findAll();
    }
}
