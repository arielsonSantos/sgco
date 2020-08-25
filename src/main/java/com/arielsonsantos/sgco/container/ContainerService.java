package com.arielsonsantos.sgco.container;

import com.arielsonsantos.sgco.client.Client;
import com.arielsonsantos.sgco.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContainerService {

    @Autowired
    private ContainerRepository repository;

    public List<Container> findAll() {
        return repository.findAll();
    }

    public Container findById(Integer id) {
        Optional<Container> container = repository.findById(id);
        return container.orElseThrow(() -> new ObjectNotFoundException("Caçamba com id " + id + " não encontrado!"));
    }
}
