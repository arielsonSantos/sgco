package com.arielsonsantos.sgco.vehicle;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class VehicleDTO implements Serializable {

    @NotEmpty(message = "Campo 'marca' é de preenchimento obrigatório!")
    private String marca;

    @NotEmpty(message = "Campo 'modelo' é de preenchimento obrigatório!")
    private String modelo;

    @NotEmpty(message = "Campo 'status' é de preenchimento obrigatório!")
    private VehicleStatus status;

    public VehicleDTO() {
    }

    public VehicleDTO(Vehicle vehicle) {
        this.marca = vehicle.getMarca();
        this.modelo = vehicle.getModelo();
        this.status = vehicle.getStatus();
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
