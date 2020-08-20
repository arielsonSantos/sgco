package com.arielsonsantos.sgco.rentalvehiclecontainerdriver;

public enum RentalVehicleContainerDriverStatus {
    ENTREGA(0),
    RETIRADA(1);

    private final Integer status;

    RentalVehicleContainerDriverStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }
}
