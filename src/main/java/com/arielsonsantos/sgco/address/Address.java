package com.arielsonsantos.sgco.address;

import com.arielsonsantos.sgco.client.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cep;
    private String numero;

    @JsonIgnore
    @ManyToMany(mappedBy = "addresses")
    private Set<Client> clients = new HashSet<>();

    public Address() {
    }

    public Address(String cep, String numero) {
        this.cep = cep;
        this.numero = numero;
    }

    public Address(AddressDTO addressDTO) {
        this(addressDTO.getCep(), addressDTO.getNumero());
    }

    public Integer getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Set<Client> getClients() {
        return clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}