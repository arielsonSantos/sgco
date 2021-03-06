package com.arielsonsantos.sgco.phone;

import java.io.Serializable;

public class PhoneListDTO implements Serializable {

    private Integer id;
    private String ddd;
    private String numero;

    public PhoneListDTO() {
    }

    public PhoneListDTO(Phone phone) {
        this.ddd = phone.getDdd();
        this.numero = phone.getNumero();
    }

    public Integer getId() {
        return id;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
