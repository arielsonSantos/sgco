package com.arielsonsantos.sgco.containertype;

import com.arielsonsantos.sgco.container.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContainerTypeService {

    @Autowired
    private ContainerTypeRepository repository;

    public List<ContainerType> findAll() {
        return repository.findAll();
    }

    public ContainerType findById(Integer id) {
        Optional<ContainerType> containerType = repository.findById(id);
        return containerType.orElse(null);
    }
}
