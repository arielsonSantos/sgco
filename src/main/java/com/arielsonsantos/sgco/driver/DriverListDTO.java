package com.arielsonsantos.sgco.driver;

import java.io.Serializable;

public class DriverListDTO implements Serializable {

    private Integer id;
    private String nome;
    private DriverStatus status;

    public DriverListDTO() {
    }

    public DriverListDTO(Driver driver) {
        this.nome = driver.getNome();
        this.status = driver.getStatus();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }
}
