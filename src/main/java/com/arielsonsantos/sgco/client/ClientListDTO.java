package com.arielsonsantos.sgco.client;

import java.io.Serializable;
import java.util.Date;

public class ClientListDTO implements Serializable {

    private Integer id;
    private String nome;
    private String sobrenome;
    private Date nascimento;
    private String cpfCnpj;
    private String rgIe;
    private String email;
    private ClientStatus status;
    private String observacoes;

    public ClientListDTO() {
    }

    public ClientListDTO(Client client) {
        this.id = client.getId();
        this.nome = client.getNome();
        this.sobrenome = client.getSobrenome();
        this.nascimento = client.getNascimento();
        this.cpfCnpj = client.getCpfCnpj();
        this.rgIe = client.getRgIe();
        this.email = client.getEmail();
        this.status = client.getStatus();
        this.observacoes = client.getObservacoes();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getRgIe() {
        return rgIe;
    }

    public String getEmail() {
        return email;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public String getObservacoes() {
        return observacoes;
    }
}
