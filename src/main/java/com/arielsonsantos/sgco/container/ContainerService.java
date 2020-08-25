package com.arielsonsantos.sgco.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerService {

    @Autowired
    private ContainerRepository repository;

    public List<Container> findAll() {
        return repository.findAll();
    }
}
