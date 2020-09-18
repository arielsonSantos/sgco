package com.arielsonsantos.sgco.dumplocation;

import com.arielsonsantos.sgco.exceptions.DataIntegrityException;
import com.arielsonsantos.sgco.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public Page<DumpLocation> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public DumpLocation findById(Integer id) {
        Optional<DumpLocation> dumpLocation = repository.findById(id);
        return dumpLocation.orElseThrow(() -> new ObjectNotFoundException("Local de despejo com id " + id + " não encontrado!"));
    }

    public DumpLocation insert(DumpLocation dumpLocation) {
        return repository.save(dumpLocation);
    }

    public void update(DumpLocation dumpLocation, Integer id) {
        findById(id);
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
