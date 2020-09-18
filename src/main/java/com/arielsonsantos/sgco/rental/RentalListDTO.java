package com.arielsonsantos.sgco.rental;

import com.arielsonsantos.sgco.address.Address;
import com.arielsonsantos.sgco.client.Client;
import com.arielsonsantos.sgco.dumplocation.DumpLocation;
import com.arielsonsantos.sgco.rentalcontainers.RentalContainers;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class RentalListDTO implements Serializable {

    private Integer id;
    private Date dataLocacao;
    private Date dataRetirada;
    private Double total;
    private Client client;
    private Address address;
    private RentalStatus status;
    private List<DumpLocation> dumpLocations;
    private Set<RentalContainers> rentalContainers;

    public RentalListDTO() {
    }

    public RentalListDTO(Rental rental) {
        this.dataLocacao = rental.getDataLocacao();
        this.dataRetirada = rental.getDataRetirada();
        this.client = rental.getClient();
        this.address = rental.getAddress();
        this.status = rental.getStatus();
        this.dumpLocations = rental.getDumpLocations();
        this.rentalContainers = rental.getRentalContainers();
    }

    public Integer getId() {
        return id;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Double getTotal() {
        total = 0D;

        for(RentalContainers rentalContainers : this.rentalContainers) {
            total += rentalContainers.getContainer().getTipo().getValor();
        }

        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public List<DumpLocation> getDumpLocations() {
        return dumpLocations;
    }

    public Set<RentalContainers> getRentalContainers() {
        return rentalContainers;
    }
}
