package com.arielsonsantos.sgco.dumplocation;

import com.arielsonsantos.sgco.driver.Driver;
import com.arielsonsantos.sgco.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DumpLocationService {

    @Autowired
    private DumpLocationRepository repository;

    public List<DumpLocation> findAll() {
        return repository.findAll();
    }

    public DumpLocation findById(Integer id) {
        Optional<DumpLocation> dumpLocation = repository.findById(id);
        return dumpLocation.orElseThrow(() -> new ObjectNotFoundException("Local de despejo com id " + id + " não encontrado!"));
    }
}
