package br.com.arielsonsantos.sgco.entities;

import br.com.arielsonsantos.sgco.entities.enums.RentalStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rental implements Serializable {
    private Integer id;
    private Date dataLocacao;
    private Date dataRetirada;
    private Double total;
    private Client client;
    private Address endereco;
    private Driver motorista;
    private Vehicle veiculo;
    private RentalStatus status;
    private DumpLocation localDespejo;
    private List<Container> cacambas = new ArrayList<>();
}
