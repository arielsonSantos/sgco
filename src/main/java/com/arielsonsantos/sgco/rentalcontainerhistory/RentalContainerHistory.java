package com.arielsonsantos.sgco.rentalcontainerhistory;

import com.arielsonsantos.sgco.container.Container;
import com.arielsonsantos.sgco.driver.Driver;
import com.arielsonsantos.sgco.rental.Rental;
import com.arielsonsantos.sgco.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class RentalContainerHistory implements Serializable {

    @EmbeddedId
    private RentalContainerHistoryPK id = new RentalContainerHistoryPK();

    public RentalContainerHistory() {
    }

    public RentalContainerHistory(Rental rental, Driver driver, Vehicle vehicle, Container container, Date date, RentalContainerHistoryStatus status) {
        id.setRental(rental);
        id.setDriver(driver);
        id.setVehicle(vehicle);
        id.setContainer(container);
        id.setDate(date);
        id.setStatus(status);
    }

    @JsonIgnore
    public Rental getRental() {
        return id.getRental();
    }

    public void setRental(Rental rental) {
        id.setRental(rental);
    }

    public Driver getDriver() {
        return id.getDriver();
    }

    public void setRental(Driver driver) {
        id.setDriver(driver);
    }

    public Vehicle getVehicle() {
        return id.getVehicle();
    }

    public void setVehicle(Vehicle vehicle) {
        id.setVehicle(vehicle);
    }

    public Container getContainer() {
        return id.getContainer();
    }

    public void setContainer(Container container) {
        id.setContainer(container);
    }

    public Date getDate() {
        return id.getDate();
    }

    public void setDate(Date date) {
        id.setDate(date);
    }

    public RentalContainerHistoryStatus getStatus() {
        return id.getStatus();
    }

    public void setStatus(RentalContainerHistoryStatus status) {
        id.setStatus(status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentalContainerHistory)) return false;
        RentalContainerHistory that = (RentalContainerHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
