package br.com.arielsonsantos.sgco.entities.enums;

public enum RentalStatus {
    VIGENTE(0),
    AGUARDANDO_ENTREGA(1),
    AGUARDANDO_RETIRADA(2),
    PAGAMENTO_ABERTO(3),
    PAGAMENTO_PARCIAL(4),
    PAGAMENTO_TOTAL(5),
    VENCIDA(6),
    FINALIZADA(7),
    CANCELADA(2);

    private final Integer status;

    RentalStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }
}
