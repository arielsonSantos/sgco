package br.com.arielsonsantos.sgco.entities;

import br.com.arielsonsantos.sgco.entities.enums.ContainerStatus;

import java.io.Serializable;
import java.util.Objects;

public class Container implements Serializable {
    private Integer id;
    private Integer numero;
    private ContainerType tipo;
    private ContainerStatus status;

    public Container() {
    }

    public Container(Integer numero, ContainerType tipo, ContainerStatus status) {
        this.numero = numero;
        this.tipo = tipo;
        this.status = status;
    }

    public Container(Integer numero, ContainerType tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public ContainerType getTipo() {
        return tipo;
    }

    public void setTipo(ContainerType tipo) {
        this.tipo = tipo;
    }

    public ContainerStatus getStatus() {
        return status;
    }

    public void setStatus(ContainerStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Container)) return false;
        Container container = (Container) o;
        return Objects.equals(id, container.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
