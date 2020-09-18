package com.arielsonsantos.sgco.phone;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class PhoneDTO implements Serializable {

    @NotEmpty(message = "Campo 'ddd' é de preenchimento obrigatório!")
    @Size(min = 2, max = 2, message = "Campo 'ddd' com formato inválido!")
    private String ddd;

    @NotEmpty(message = "Campo 'número' é de preenchimento obrigatório!")
    private String numero;

    public PhoneDTO() {
    }

    public PhoneDTO(Phone phone) {
        this.ddd = phone.getDdd();
        this.numero = phone.getNumero();
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
}
