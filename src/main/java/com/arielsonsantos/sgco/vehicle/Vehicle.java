package com.arielsonsantos.sgco.vehicle;

import com.arielsonsantos.sgco.rentalcontainerhistory.RentalContainerHistory;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String marca;
    private String modelo;
    private VehicleStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "id.vehicle")
    private Set<RentalContainerHistory> rentalContainerHistories = new HashSet<>();

    public Vehicle() {
    }

    public Vehicle(String marca, String modelo, VehicleStatus status) {
        this.marca = marca;
        this.modelo = modelo;
        this.status = status;
    }

    public Vehicle(VehicleDTO vehicleDTO) {
        this(vehicleDTO.getMarca(), vehicleDTO.getModelo(), vehicleDTO.getStatus());
    }

    public Integer getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public Set<RentalContainerHistory> getRentalContainerHistories() {
        return rentalContainerHistories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
