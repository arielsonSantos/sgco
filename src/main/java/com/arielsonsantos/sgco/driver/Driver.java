package com.arielsonsantos.sgco.driver;

import com.arielsonsantos.sgco.rentalcontainers.RentalContainers;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private DriverStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "id.rental")
    private List<RentalContainers> locacoes = new ArrayList<>();

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

    public List<RentalContainers> getLocacoes() {
        return locacoes;
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
