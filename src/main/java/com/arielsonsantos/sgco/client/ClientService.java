package com.arielsonsantos.sgco.client;

import com.arielsonsantos.sgco.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Integer id) {
        Optional<Client> client = repository.findById(id);
        return client.orElse(null);
    }
}
