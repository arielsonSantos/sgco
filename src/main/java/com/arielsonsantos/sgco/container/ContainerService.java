package com.arielsonsantos.sgco.container;

import com.arielsonsantos.sgco.exceptions.DataIntegrityException;
import com.arielsonsantos.sgco.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContainerService {

    @Autowired
    private ContainerRepository repository;

    public List<Container> findAll() {
        return repository.findAll();
    }

    public Container findById(Integer id) {
        Optional<Container> container = repository.findById(id);
        return container.orElseThrow(() -> new ObjectNotFoundException("Caçamba com id " + id + " não encontrado!"));
    }

    public Container insert(Container container) {
        return repository.save(container);
    }

    public void update(Container container) {
        findById(container.getId());
        repository.save(container);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir a caçamba, pois existem registros associados a ela!");
        }
    }
}
