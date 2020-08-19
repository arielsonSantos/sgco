package br.com.arielsonsantos.sgco.entities;

import br.com.arielsonsantos.sgco.entities.enums.DriverStatus;

import java.io.Serializable;
import java.util.Objects;

public class Driver implements Serializable {
    private Integer id;
    private String nome;
    private DriverStatus status;

    public Driver() {
    }

    public Driver(String nome, DriverStatus status) {
        this.nome = nome;
        this.status = status;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
