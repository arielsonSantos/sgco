package com.arielsonsantos.sgco.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repository;

    public List<Driver> findAll() {
        return repository.findAll();
    }
}
