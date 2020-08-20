package com.arielsonsantos.sgco.rental;

import com.arielsonsantos.sgco.address.Address;
import com.arielsonsantos.sgco.client.Client;
import com.arielsonsantos.sgco.container.Container;
import com.arielsonsantos.sgco.driver.Driver;
import com.arielsonsantos.sgco.dumplocation.DumpLocation;
import com.arielsonsantos.sgco.rentalvehiclecontainerdriver.RentalVehicleContainerDriver;
import com.arielsonsantos.sgco.vehicle.Vehicle;

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
    private Address endereco;

    private RentalStatus status;

    @ManyToMany
    @JoinTable(name = "rental_dump", joinColumns = @JoinColumn(name = "rental_id"), inverseJoinColumns = @JoinColumn(name = "dump_id"))
    private List<DumpLocation> locaisDespejo = new ArrayList<>();

    @OneToMany(mappedBy = "id.cacamba")
    private Set<RentalVehicleContainerDriver> cacambas = new HashSet<>();

    @OneToMany(mappedBy = "id.veiculo")
    private List<RentalVehicleContainerDriver> veiculos = new ArrayList<>();

    @OneToMany(mappedBy = "id.motorista")
    private List<RentalVehicleContainerDriver> motoristas = new ArrayList<>();

    public Rental() {
    }

    public Rental(Date dataLocacao, Date dataRetirada, Double total, Client client, Address endereco, RentalStatus status) {
        this.dataLocacao = dataLocacao;
        this.dataRetirada = dataRetirada;
        this.total = total;
        this.client = client;
        this.endereco = endereco;
        this.status = status;
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

    public Address getEndereco() {
        return endereco;
    }

    public void setEndereco(Address endereco) {
        this.endereco = endereco;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public List<DumpLocation> getLocaisDespejo() {
        return locaisDespejo;
    }

    public List<RentalVehicleContainerDriver> getVeiculos() {
        return veiculos;
    }

    public Set<RentalVehicleContainerDriver> getCacambas() {
        return cacambas;
    }

    public List<RentalVehicleContainerDriver> getMotoristas() {
        return motoristas;
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
