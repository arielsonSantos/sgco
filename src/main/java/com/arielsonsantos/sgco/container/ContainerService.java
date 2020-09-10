package com.arielsonsantos.sgco.container;

import com.arielsonsantos.sgco.client.Client;
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
public class ContainerService {

    @Autowired
    private ContainerRepository repository;

    public List<Container> findAll() {
        return repository.findAll();
    }

    public Page<Container> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Container findById(Integer id) {
        Optional<Container> container = repository.findById(id);
        return container.orElseThrow(() -> new ObjectNotFoundException("Caçamba com id " + id + " não encontrado!"));
    }

    public Container insert(Container container) {
        return repository.save(container);
    }

    public void update(Container newContainer, Integer id) {
        Container container = findById(id);
        container.setNumero(newContainer.getNumero());
        container.setTipo(newContainer.getTipo());
        container.setStatus(newContainer.getStatus());
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
