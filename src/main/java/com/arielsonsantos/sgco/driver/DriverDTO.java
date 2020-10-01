package com.arielsonsantos.sgco.driver;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class DriverDTO implements Serializable {

    @NotEmpty(message = "Campo 'nome' é de preenchimento obrigatório!")
    private String nome;

    @NotNull(message = "Campo 'status' é de preenchimento obrigatório!")
    private DriverStatus status;

    public DriverDTO() {
    }

    public DriverDTO(Driver driver) {
        this.nome = driver.getNome();
        this.status = driver.getStatus();
    }

    public String getNome() {
        return nome;
    }

    public DriverStatus getStatus() {
        return status;
    }
}
