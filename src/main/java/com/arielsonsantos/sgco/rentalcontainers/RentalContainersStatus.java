package com.arielsonsantos.sgco.rentalcontainers;

public enum RentalContainersStatus {
    ENTREGA(0),
    RETIRADA(1);

    private final Integer status;

    RentalContainersStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }
}
