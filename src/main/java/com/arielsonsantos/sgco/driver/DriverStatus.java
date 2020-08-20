package com.arielsonsantos.sgco.driver;

public enum DriverStatus {
    PATIO(0),
    ENTREGA(1),
    TRECHO(2),
    RETIRADA(3),
    DESPEJO(4);

    private final Integer status;

    DriverStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }
}
