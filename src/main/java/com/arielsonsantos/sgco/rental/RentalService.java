package com.arielsonsantos.sgco.rental;

import com.arielsonsantos.sgco.phone.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    @Autowired
    private RentalRepository repository;

    public List<Rental> findAll() {
        return repository.findAll();
    }

    public Rental findById(Integer id) {
        Optional<Rental> rental = repository.findById(id);
        return rental.orElse(null);
    }
}
