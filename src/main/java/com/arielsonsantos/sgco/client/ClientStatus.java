package com.arielsonsantos.sgco.client;

public enum ClientStatus {
    ATIVO(0),
    INADIMPLENTE(1),
    INATIVO(2);

    private final Integer status;

    ClientStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }
}
