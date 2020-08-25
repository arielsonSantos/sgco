package com.arielsonsantos.sgco.client;

import com.arielsonsantos.sgco.address.Address;
import com.arielsonsantos.sgco.phone.Phone;
import com.arielsonsantos.sgco.rental.Rental;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    private Date nascimento;
    private String observacoes;
    private String cpfCnpj;
    private String rgIe;
    private String email;
    private ClientStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<Rental> rentals = new HashSet<>();

    @ManyToMany(mappedBy = "clients")
    private Set<Address> addresses = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "clients")
    private Set<Phone> phones = new HashSet<>();

    public Client() {
    }

    public Client(String nome, String sobrenome, Date nascimento, String observacoes, String cpfCnpj, String rgIe, String email, ClientStatus status) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nascimento = nascimento;
        this.observacoes = observacoes;
        this.cpfCnpj = cpfCnpj;
        this.rgIe = rgIe;
        this.email = email;
        this.status = status;
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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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

    public Set<Rental> getRentals() {
        return rentals;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
