package com.arielsonsantos.sgco.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public List<Address> findAll() {
        return repository.findAll();
    }
}
