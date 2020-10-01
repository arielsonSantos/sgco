package com.arielsonsantos.sgco.dumplocation;

import java.io.Serializable;

public class DumpLocationListDTO implements Serializable {

    private Integer id;
    private String nome;
    private Double valor;

    public DumpLocationListDTO() {
    }

    public DumpLocationListDTO(DumpLocation dumpLocation) {
        this.nome = dumpLocation.getNome();
        this.valor = dumpLocation.getValor();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }
}