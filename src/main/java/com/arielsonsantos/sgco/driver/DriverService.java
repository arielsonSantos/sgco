package com.arielsonsantos.sgco.driver;

import com.arielsonsantos.sgco.containertype.ContainerType;
import com.arielsonsantos.sgco.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repository;

    public List<Driver> findAll() {
        return repository.findAll();
    }

    public Driver findById(Integer id) {
        Optional<Driver> driver = repository.findById(id);
        return driver.orElseThrow(() -> new ObjectNotFoundException("Motorista com id " + id + " não encontrado!"));
    }
}
