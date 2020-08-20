package com.arielsonsantos.sgco.vehicle;

import com.arielsonsantos.sgco.rental.Rental;
import com.arielsonsantos.sgco.rentalvehiclecontainerdriver.RentalVehicleContainerDriver;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String marca;
    private String modelo;
    private VehicleStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "id.rental")
    private List<RentalVehicleContainerDriver> locacoes = new ArrayList<>();

    public Vehicle() {
    }

    public Vehicle(String marca, String modelo, VehicleStatus status) {
        this.marca = marca;
        this.modelo = modelo;
        this.status = status;
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

    public List<RentalVehicleContainerDriver> getLocacoes() {
        return locacoes;
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
