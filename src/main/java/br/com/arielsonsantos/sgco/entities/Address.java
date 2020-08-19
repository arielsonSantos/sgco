package br.com.arielsonsantos.sgco.entities;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {
    private Integer id;
    private Client client;
    private String cep;
    private String numero;

    public Address() {
    }

    public Address(Client client, String cep, String numero) {
        this.client = client;
        this.cep = cep;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
