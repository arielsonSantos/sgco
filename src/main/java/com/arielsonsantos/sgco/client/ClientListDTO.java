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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRgIe() {
        return rgIe;
    }

    public void setRgIe(String rgIe) {
        this.rgIe = rgIe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
