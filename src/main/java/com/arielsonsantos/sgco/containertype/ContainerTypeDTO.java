package com.arielsonsantos.sgco.containertype;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class ContainerTypeDTO {

    @NotEmpty(message = "Campo 'nome' é de preenchimento obrigatório!")
    private String nome;

    @NotNull(message = "Campo 'valor' é de preenchimento obrigatório!")
    @PositiveOrZero(message = "Valor do tipo de caçamba inválido!")
    private Double valor;

    public ContainerTypeDTO() {
    }

    public ContainerTypeDTO(ContainerType containerType) {
        this.nome = containerType.getNome();
        this.valor = containerType.getValor();
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }
}
