package com.arielsonsantos.sgco.rentalcontainers;

import com.arielsonsantos.sgco.container.Container;
import com.arielsonsantos.sgco.rental.Rental;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RentalContainersPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "container_id")
    private Container container;

    public RentalContainersPK() {
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentalContainersPK)) return false;
        RentalContainersPK that = (RentalContainersPK) o;
        return Objects.equals(rental, that.rental) &&
                Objects.equals(container, that.container);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rental, container);
    }
}
