package com.arielsonsantos.sgco.dumplocation;

import com.arielsonsantos.sgco.exceptions.DataIntegrityException;
import com.arielsonsantos.sgco.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public DumpLocation insert(DumpLocation dumpLocation) {
        return repository.save(dumpLocation);
    }

    public void update(DumpLocation dumpLocation) {
        findById(dumpLocation.getId());
        repository.save(dumpLocation);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o local de despejo, pois existem registros associados a ele!");
        }
    }
}
