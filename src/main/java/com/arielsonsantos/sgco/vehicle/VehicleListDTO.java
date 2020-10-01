package com.arielsonsantos.sgco.vehicle;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class VehicleListDTO implements Serializable {

    private Integer id;
    private String marca;
    private String modelo;
    private VehicleStatus status;
    private Set<Integer> rentals = new HashSet<>();

    public VehicleListDTO() {
    }

    public VehicleListDTO(Vehicle vehicle) {
        this.marca = vehicle.getMarca();
        this.modelo = vehicle.getModelo();
        this.status = vehicle.getStatus();
        this.rentals = vehicle.getRentalContainerHistories().stream().map(rentalContainerHistory -> rentalContainerHistory.getRental().getId()).collect(Collectors.toSet());
    }

    public Integer getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public Set<Integer> getRentals() {
        return rentals;
    }
}
