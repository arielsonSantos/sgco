package com.arielsonsantos.sgco.rental;

import com.arielsonsantos.sgco.address.Address;
import com.arielsonsantos.sgco.client.Client;
import com.arielsonsantos.sgco.dumplocation.DumpLocation;
import com.arielsonsantos.sgco.rentalcontainerhistory.RentalContainerHistory;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class RentalDTO implements Serializable {

    @NotNull(message = "Campo 'data da locação' é de preenchimento obrigatório!")
    private Date dataLocacao;

    @NotNull(message = "Campo 'data da retirada' é de preenchimento obrigatório!")
    private Date dataRetirada;

    @NotNull(message = "Campo 'cliente' é de preenchimento obrigatório!")
    private Client client;

    @NotNull(message = "Campo 'endereço' é de preenchimento obrigatório!")
    private Address address;

    @NotNull(message = "Campo 'status' é de preenchimento obrigatório!")
    private RentalStatus status;

    private List<DumpLocation> dumpLocations;
    private Set<RentalContainerHistory> rentalContainerHistories;

    public RentalDTO() {
    }

    public RentalDTO(Rental rental) {
        this.dataLocacao = rental.getDataLocacao();
        this.dataRetirada = rental.getDataRetirada();
        this.client = rental.getClient();
        this.address = rental.getAddress();
        this.status = rental.getStatus();
        this.dumpLocations = rental.getDumpLocations();
        this.rentalContainerHistories = rental.getRentalContainerHistories();
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
}
