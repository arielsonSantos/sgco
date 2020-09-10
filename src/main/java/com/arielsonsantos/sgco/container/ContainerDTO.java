package com.arielsonsantos.sgco.container;

import com.arielsonsantos.sgco.containertype.ContainerType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ContainerDTO {

    @NotEmpty(message = "Campo 'numero' é de preenchimento obrigatório!")
    @Positive(message = "Número da caçamba inválido!")
    private Integer numero;

    @NotEmpty(message = "Campo 'tipo' é de preenchimento obrigatório!")
    private ContainerType tipo;

    @NotEmpty(message = "Campo 'status' é de preenchimento obrigatório!")
    private ContainerStatus status;

    public ContainerDTO() {
    }

    public ContainerDTO(Container container) {
        this.numero = container.getNumero();
        this.tipo = container.getTipo();
        this.status = container.getStatus();
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
