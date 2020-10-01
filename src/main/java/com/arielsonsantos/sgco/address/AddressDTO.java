package com.arielsonsantos.sgco.address;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class AddressDTO implements Serializable {

    @NotEmpty(message = "Campo 'CEP' é de preenchimento obrigatório!")
    @Size(min = 8, max = 8, message = "Formato do CEP incorreto!")
    private String cep;

    @NotEmpty(message = "Campo 'número' é de preenchimento obrigatório!")
    private String numero;

    public AddressDTO() {
    }

    public AddressDTO(Address address) {
        this.cep = address.getCep();
        this.numero = address.getNumero();
    }

    public String getCep() {
        return cep;
    }

    public String getNumero() {
        return numero;
    }
}
