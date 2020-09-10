package com.arielsonsantos.sgco.container;

import com.arielsonsantos.sgco.containertype.ContainerType;

public class ContainerListDTO {

    private Integer id;
    private Integer numero;
    private ContainerType tipo;
    private ContainerStatus status;

    public ContainerListDTO() {
    }

    public ContainerListDTO(Container container) {
        this.id = container.getId();
        this.numero = container.getNumero();
        this.tipo = container.getTipo();
        this.status = container.getStatus();
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public ContainerType getTipo() {
        return tipo;
    }

    public ContainerStatus getStatus() {
        return status;
    }
}
