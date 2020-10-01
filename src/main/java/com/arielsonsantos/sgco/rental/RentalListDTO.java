package com.arielsonsantos.sgco.rental;

import com.arielsonsantos.sgco.address.Address;
import com.arielsonsantos.sgco.client.Client;
import com.arielsonsantos.sgco.dumplocation.DumpLocation;
import com.arielsonsantos.sgco.rentalcontainerhistory.RentalContainerHistory;

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
    private Set<RentalContainerHistory> rentalContainerHistories;

    public RentalListDTO() {
    }

    public RentalListDTO(Rental rental) {
        this.id = rental.getId();
        this.dataLocacao = rental.getDataLocacao();
        this.dataRetirada = rental.getDataRetirada();
        this.total = rental.getTotal();
        this.client = rental.getClient();
        this.address = rental.getAddress();
        this.status = rental.getStatus();
        this.dumpLocations = rental.getDumpLocations();
        this.rentalContainerHistories = rental.getRentalContainerHistories();
    }

    public Integer getId() {
        return id;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public Client getClient() {
        return client;
    }

    public Address getAddress() {
        return address;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public List<DumpLocation> getDumpLocations() {
        return dumpLocations;
    }

    public Set<RentalContainerHistory> getRentalContainerHistories() {
        return rentalContainerHistories;
    }

    public Double getTotal() {
        return total;
    }
}
