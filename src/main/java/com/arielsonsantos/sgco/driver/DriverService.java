package com.arielsonsantos.sgco.driver;

import com.arielsonsantos.sgco.containertype.ContainerType;
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
public class DriverService {

    @Autowired
    private DriverRepository repository;

    public List<Driver> findAll() {
        return repository.findAll();
    }

    public Page<Driver> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Driver findById(Integer id) {
        Optional<Driver> driver = repository.findById(id);
        return driver.orElseThrow(() -> new ObjectNotFoundException("Motorista com id " + id + " não encontrado!"));
    }

    public Driver insert(Driver driver) {
        return repository.save(driver);
    }

    public void update(Driver driver) {
        findById(driver.getId());
        repository.save(driver);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o motorista, pois existem registros associados a ele!");
        }
    }
}
