package com.arielsonsantos.sgco.rentalcontainers;

import com.arielsonsantos.sgco.container.Container;
import com.arielsonsantos.sgco.rental.Rental;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class RentalContainers implements Serializable {

    @EmbeddedId
    private RentalContainersPK id = new RentalContainersPK();

    private RentalContainersStatus status;

    public RentalContainers() {
    }

    public RentalContainers(Rental rental, Container container, RentalContainersStatus status) {
        id.setRental(rental);
        id.setContainer(container);
        this.status = status;
    }

    @JsonIgnore
    public Rental getRental() {
        return id.getRental();
    }

    public void setRental(Rental rental) {
        id.setRental(rental);
    }

    public Container getContainer() {
        return id.getContainer();
    }

    public void setContainer(Container container) {
        id.setContainer(container);
    }

    public RentalContainersStatus getStatus() {
        return status;
    }

    public void setStatus(RentalContainersStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentalContainers)) return false;
        RentalContainers that = (RentalContainers) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
