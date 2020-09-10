package com.arielsonsantos.sgco.containertype;

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
public class ContainerTypeService {

    @Autowired
    private ContainerTypeRepository repository;

    public List<ContainerType> findAll() {
        return repository.findAll();
    }

    public Page<ContainerType> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public ContainerType findById(Integer id) {
        Optional<ContainerType> containerType = repository.findById(id);
        return containerType.orElseThrow(() -> new ObjectNotFoundException("Tipo de caçamba com id " + id + " não encontrado!"));
    }

    public ContainerType insert(ContainerType containerType) {
        return repository.save(containerType);
    }

    public void update(ContainerType newContainerType, Integer id) {
        ContainerType containerType = findById(id);
        containerType.setNome(newContainerType.getNome());
        containerType.setValor(newContainerType.getValor());
        repository.save(containerType);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o tipo de caçamba, pois existem registros associados a ele!");
        }
    }
}
