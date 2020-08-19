package br.com.arielsonsantos.sgco.entities.enums;

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
