package com.arielsonsantos.sgco.rentalcontainerhistory;

public enum RentalContainerHistoryStatus {
    ENTREGA(0),
    RETIRADA(1);

    private final Integer status;

    RentalContainerHistoryStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }
}
