package com.arielsonsantos.sgco.rentalcontainerhistory;

import com.arielsonsantos.sgco.container.Container;
import com.arielsonsantos.sgco.driver.Driver;
import com.arielsonsantos.sgco.rental.Rental;
import com.arielsonsantos.sgco.vehicle.Vehicle;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class RentalContainerHistoryPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "container_id")
    private Container container;

    private Date date;
    private RentalContainerHistoryStatus status;

    public RentalContainerHistoryPK() {
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public RentalContainerHistoryStatus getStatus() {
        return status;
    }

    public void setStatus(RentalContainerHistoryStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentalContainerHistoryPK)) return false;
        RentalContainerHistoryPK that = (RentalContainerHistoryPK) o;
        return Objects.equals(rental, that.rental) &&
                Objects.equals(driver, that.driver) &&
                Objects.equals(vehicle, that.vehicle) &&
                Objects.equals(container, that.container) &&
                Objects.equals(date, that.date) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rental, driver, vehicle, container, date, status);
    }
}
