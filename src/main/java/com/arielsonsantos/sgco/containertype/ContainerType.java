package com.arielsonsantos.sgco.containertype;

import com.arielsonsantos.sgco.container.Container;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class ContainerType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double valor;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo")
    private Set<Container> cacambas = new HashSet<>();

    public ContainerType() {
    }

    public ContainerType(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public ContainerType(ContainerTypeDTO containerTypeDTO) {
        this(containerTypeDTO.getNome(), containerTypeDTO.getValor());
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

    public Set<Container> getCacambas() {
        return cacambas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContainerType)) return false;
        ContainerType that = (ContainerType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
