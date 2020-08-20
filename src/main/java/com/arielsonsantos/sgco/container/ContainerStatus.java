package com.arielsonsantos.sgco.container;

public enum ContainerStatus {
    DISPONIVEL(0),
    LOCADA(1),
    ENTREGA(2),
    RETIRADA(3),
    DESPEJO(4),
    INATIVA(5);

    private final Integer status;

    ContainerStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }
}
