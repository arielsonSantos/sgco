package com.arielsonsantos.sgco.rental;

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
public class RentalService {

    @Autowired
    private RentalRepository repository;

    public List<Rental> findAll() {
        return repository.findAll();
    }

    public Page<Rental> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Rental findById(Integer id) {
        Optional<Rental> rental = repository.findById(id);
        return rental.orElseThrow(() -> new ObjectNotFoundException("Locação com id " + id + " não encontrado!"));
    }

    public Rental insert(Rental rental) {
        return repository.save(rental);
    }

    public void update(Rental rental) {
        findById(rental.getId());
        repository.save(rental);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o telefone, pois existem registros associados a ele!");
        }
    }
}
