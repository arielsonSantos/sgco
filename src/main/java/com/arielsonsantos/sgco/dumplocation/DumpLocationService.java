package com.arielsonsantos.sgco.dumplocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DumpLocationService {

    @Autowired
    private DumpLocationRepository repository;

    public List<DumpLocation> findAll() {
        return repository.findAll();
    }
}
