package com.arielsonsantos.sgco.vehicle;

import java.io.Serializable;

public class VehicleListDTO implements Serializable {

    private Integer id;
    private String marca;
    private String modelo;
    private VehicleStatus status;

    public VehicleListDTO() {
    }

    public VehicleListDTO(Vehicle vehicle) {
        this.marca = vehicle.getMarca();
        this.modelo = vehicle.getModelo();
        this.status = vehicle.getStatus();
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
}
