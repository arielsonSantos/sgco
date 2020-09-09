package com.arielsonsantos.sgco.address;

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
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public List<Address> findAll() {
        return repository.findAll();
    }

    public Page<Address> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Address findById(Integer id) {
        Optional<Address> address = repository.findById(id);
        return address.orElseThrow(() -> new ObjectNotFoundException("Endereço com id " + id + " não encontrado!"));
    }

    public Address insert(Address address) {
        return repository.save(address);
    }

    public void update(Address newAddress, Integer id) {
        Address address = findById(id);
        address.setCep(newAddress.getCep());
        address.setNumero(newAddress.getNumero());
        repository.save(address);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o endereço, pois existem registros associados a ele!");
        }
    }
}
