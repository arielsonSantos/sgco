package br.com.arielsonsantos.sgco.entities;

import java.io.Serializable;
import java.util.Objects;

public class Phone implements Serializable {
    private Integer id;
    private Client client;
    private String ddd;
    private String numero;

    public Phone() {
    }

    public Phone(Client client, String ddd, String numero) {
        this.client = client;
        this.ddd = ddd;
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

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
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
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(id, phone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
