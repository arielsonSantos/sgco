package com.arielsonsantos.sgco.containertype;

public class ContainerTypeListDTO {

    private Integer id;
    private String nome;
    private Double valor;

    public ContainerTypeListDTO() {
    }

    public ContainerTypeListDTO(ContainerType containerType) {
        this.id = containerType.getId();
        this.nome = containerType.getNome();
        this.valor = containerType.getValor();
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
