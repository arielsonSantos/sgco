package com.arielsonsantos.sgco.driver;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DriverListDTO implements Serializable {

    private Integer id;
    private String nome;
    private DriverStatus status;
    private Set<Integer> rentals = new HashSet<>();

    public DriverListDTO() {
    }

    public DriverListDTO(Driver driver) {
        this.nome = driver.getNome();
        this.status = driver.getStatus();
        this.rentals = driver.getRentalContainerHistories().stream().map(rentalContainerHistory -> rentalContainerHistory.getRental().getId()).collect(Collectors.toSet());
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public Set<Integer> getRentals() {
        return rentals;
    }
}
