package com.arielsonsantos.sgco.dumplocation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

public class DumpLocationDTO implements Serializable {

    @NotEmpty(message = "Campo 'nome' é de preenchimento obrigatório!")
    private String nome;

    @NotNull(message = "Campo 'valor' é de preenchimento obrigatório!")
    @PositiveOrZero(message = "Valor do local de despejo inválido!")
    private Double valor;

    public DumpLocationDTO() {
    }

    public DumpLocationDTO(DumpLocation dumpLocation) {
        this.nome = dumpLocation.getNome();
        this.valor = dumpLocation.getValor();
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }
}