package com.arielsonsantos.sgco.container;

import com.arielsonsantos.sgco.containertype.ContainerType;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainerListDTO {

    private Integer id;
    private Integer numero;
    private ContainerType tipo;
    private ContainerStatus status;
    private Set<Integer> rentals = new HashSet<>();

    public ContainerListDTO() {
    }

    public ContainerListDTO(Container container) {
        this.id = container.getId();
        this.numero = container.getNumero();
        this.tipo = container.getTipo();
        this.status = container.getStatus();
        this.rentals = container.getRentalContainerHistories().stream().map(rentalContainerHistory -> rentalContainerHistory.getRental().getId()).collect(Collectors.toSet());
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public ContainerType getTipo() {
        return tipo;
    }

    public ContainerStatus getStatus() {
        return status;
    }

    public Set<Integer> getRentals() {
        return rentals;
    }
}
