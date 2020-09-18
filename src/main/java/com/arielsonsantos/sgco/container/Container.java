package com.arielsonsantos.sgco.container;

import com.arielsonsantos.sgco.containertype.ContainerType;
import com.arielsonsantos.sgco.rental.Rental;
import com.arielsonsantos.sgco.rentalcontainers.RentalContainers;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Container implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private Integer numero;

    @ManyToOne()
    @JoinColumn(name = "type_id")
    private ContainerType tipo;

    private ContainerStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "id.rental")
    private Set<RentalContainers> rentalContainers = new HashSet<>();

    public Container() {
    }

    public Container(Integer numero, ContainerType tipo, ContainerStatus status) {
        this.numero = numero;
        this.tipo = tipo;
        this.status = status;
    }

    public Container(ContainerDTO containerDTO) {
        this(containerDTO.getNumero(), containerDTO.getTipo(), containerDTO.getStatus());
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public ContainerType getTipo() {
        return tipo;
    }

    public void setTipo(ContainerType tipo) {
        this.tipo = tipo;
    }

    public ContainerStatus getStatus() {
        return status;
    }

    public void setStatus(ContainerStatus status) {
        this.status = status;
    }

    public Set<RentalContainers> getRentalContainers() {
        return rentalContainers;
    }

    @JsonIgnore // TODO alterar para @JsonBackReference?
    public List<Rental> getRentals() {
         List<Rental> rentals = new ArrayList<>();

         for(RentalContainers  rentalContainers: this.rentalContainers) {
             rentals.add(rentalContainers.getRental());
         }

         return rentals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Container)) return false;
        Container container = (Container) o;
        return Objects.equals(id, container.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
