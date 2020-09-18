package com.arielsonsantos.sgco.dumplocation;

import com.arielsonsantos.sgco.rental.Rental;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class DumpLocation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double valor;

    @JsonIgnore
    @ManyToMany(mappedBy = "dumpLocations")
    private List<Rental> rentals = new ArrayList<>();

    public DumpLocation() {
    }

    public DumpLocation(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public DumpLocation(DumpLocationDTO dumpLocationDTO) {
        this(dumpLocationDTO.getNome(), dumpLocationDTO.getValor());
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DumpLocation)) return false;
        DumpLocation that = (DumpLocation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}