package com.arielsonsantos.sgco.vehicle;

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
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    public Vehicle findById(Integer id) {
        Optional<Vehicle> vehicle = repository.findById(id);
        return vehicle.orElseThrow(() -> new ObjectNotFoundException("Veículo com id " + id + " não encontrado!"));
    }

    public Page<Vehicle> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Vehicle insert(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public void update(Vehicle vehicle) {
        findById(vehicle.getId());
        repository.save(vehicle);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o veículo, pois existem registros associados a ele!");
        }
    }
}
