package com.arielsonsantos.sgco.rental;

import com.arielsonsantos.sgco.address.Address;
import com.arielsonsantos.sgco.client.Client;
import com.arielsonsantos.sgco.container.Container;
import com.arielsonsantos.sgco.dumplocation.DumpLocation;
import com.arielsonsantos.sgco.rentalcontainerhistory.RentalContainerHistory;
import com.arielsonsantos.sgco.rentalcontainerhistory.RentalContainerHistoryStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Rental implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dataLocacao;
    private Date dataRetirada;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private RentalStatus status;

    @ManyToMany
    @JoinTable(name = "rental_dump", joinColumns = @JoinColumn(name = "rental_id"), inverseJoinColumns = @JoinColumn(name = "dump_id"))
    private List<DumpLocation> dumpLocations = new ArrayList<>();

    @OneToMany(mappedBy = "id.rental")
    private Set<RentalContainerHistory> rentalContainerHistories = new HashSet<>();

    public Rental() {
    }

    public Rental(Date dataLocacao, Date dataRetirada, Client client, Address address, RentalStatus status) {
        this.dataLocacao = dataLocacao;
        this.dataRetirada = dataRetirada;
        this.client = client;
        this.address = address;
        this.status = status;
    }

    public Rental(RentalDTO rentalDTO) {
        this(rentalDTO.getDataLocacao(), rentalDTO.getDataRetirada(), rentalDTO.getClient(), rentalDTO.getAddress(), rentalDTO.getStatus());
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

        this.rentalContainerHistories.forEach(rentalContainerHistory -> {
            if (rentalContainerHistory.getStatus() == RentalContainerHistoryStatus.ENTREGA) {
                total += rentalContainerHistory.getContainer().getTipo().getValor();
            }
        });

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

    public Set<RentalContainerHistory> getRentalContainerHistories() {
        return rentalContainerHistories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rental)) return false;
        Rental rental = (Rental) o;
        return Objects.equals(id, rental.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
