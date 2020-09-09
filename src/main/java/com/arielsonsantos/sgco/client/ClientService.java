package com.arielsonsantos.sgco.client;

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
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Client findById(Integer id) {
        Optional<Client> client = repository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException("Cliente com id " + id + " não encontrado!"));
    }

    public Client insert(Client client) {
        return repository.save(client);
    }

    public void update(Client newClient, Integer id) {
        Client client = findById(id);
        client.setNome(newClient.getNome());
        client.setSobrenome(newClient.getSobrenome());
        client.setNascimento(newClient.getNascimento());
        client.setObservacoes(newClient.getObservacoes());
        client.setCpfCnpj(newClient.getCpfCnpj());
        client.setRgIe(newClient.getRgIe());
        client.setEmail(newClient.getEmail());
        client.setStatus(newClient.getStatus());
        repository.save(client);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o cliente, pois existem registros associados a ele!");
        }
    }
}
