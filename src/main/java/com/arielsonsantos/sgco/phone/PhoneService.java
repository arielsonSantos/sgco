package com.arielsonsantos.sgco.phone;

import com.arielsonsantos.sgco.exceptions.DataIntegrityException;
import com.arielsonsantos.sgco.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository repository;

    public List<Phone> findAll() {
        return repository.findAll();
    }

    public Phone findById(Integer id) {
        Optional<Phone> phone = repository.findById(id);
        return phone.orElseThrow(() -> new ObjectNotFoundException("Telefone com id " + id + " não encontrado!"));
    }

    public Phone insert(Phone phone) {
        return repository.save(phone);
    }

    public void update(Phone phone) {
        findById(phone.getId());
        repository.save(phone);
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
