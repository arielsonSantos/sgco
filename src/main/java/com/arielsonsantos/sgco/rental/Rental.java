package com.arielsonsantos.sgco.rental;

import com.arielsonsantos.sgco.client.Client;
import com.arielsonsantos.sgco.container.Container;
import com.arielsonsantos.sgco.driver.Driver;
import com.arielsonsantos.sgco.address.Address;
import com.arielsonsantos.sgco.dumplocation.DumpLocation;
import com.arielsonsantos.sgco.vehicle.Vehicle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Entity
public class Rental implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
