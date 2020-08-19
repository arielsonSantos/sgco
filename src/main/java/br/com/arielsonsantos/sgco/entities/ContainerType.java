package br.com.arielsonsantos.sgco.entities;

import java.io.Serializable;
import java.util.Objects;

public class ContainerType implements Serializable {
    private Integer id;
    private String nome;
    private Double valor;

    public ContainerType() {
    }

    public ContainerType(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
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
        if (!(o instanceof ContainerType)) return false;
        ContainerType that = (ContainerType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
