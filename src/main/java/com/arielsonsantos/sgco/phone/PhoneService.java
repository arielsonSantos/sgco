package com.arielsonsantos.sgco.phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository repository;

    public List<Phone> findAll() {
        return repository.findAll();
    }
}
