package com.arielsonsantos.sgco.address;

import com.arielsonsantos.sgco.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public List<Address> findAll() {
        return repository.findAll();
    }

    public Address findById(Integer id) {
        Optional<Address> address = repository.findById(id);
        return address.orElseThrow(() -> new ObjectNotFoundException("Endereço com id " + id + " não encontrado!"));
    }

}
