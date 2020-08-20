package com.arielsonsantos.sgco.vehicle;

public enum VehicleStatus {
    ATIVO(0),
    MANUTENCAO(1),
    INATIVO(2);

    private final Integer status;

    VehicleStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }
}
