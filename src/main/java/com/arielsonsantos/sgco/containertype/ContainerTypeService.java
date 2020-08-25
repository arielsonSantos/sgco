package com.arielsonsantos.sgco.containertype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerTypeService {

    @Autowired
    private ContainerTypeRepository repository;

    public List<ContainerType> findAll() {
        return repository.findAll();
    }
}
