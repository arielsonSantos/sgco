package com.arielsonsantos.sgco.phone;

import com.arielsonsantos.sgco.dumplocation.DumpLocation;
import com.arielsonsantos.sgco.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository repository;

    public List<Phone> findAll() {
        return repository.findAll();
    }

    public Phone findById(Integer id) {
        Optional<Phone> phone = repository.findById(id);
        return phone.orElseThrow(() -> new ObjectNotFoundException("Telefone com id " + id + " não encontrado!"));
    }
}
