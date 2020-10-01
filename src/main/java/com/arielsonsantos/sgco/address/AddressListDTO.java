package com.arielsonsantos.sgco.address;

import java.io.Serializable;

public class AddressListDTO implements Serializable {

    private Integer id;
    private String cep;
    private String numero;

    public AddressListDTO() {
    }

    public AddressListDTO(Address address) {
        this.id = address.getId();
        this.cep = address.getCep();
        this.numero = address.getNumero();
    }

    public Integer getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getNumero() {
        return numero;
    }
}
