package com.arielsonsantos.sgco.drivervehicle;

import com.arielsonsantos.sgco.driver.Driver;
import com.arielsonsantos.sgco.vehicle.Vehicle;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DriverVehiclePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DriverVehiclePK)) return false;
        DriverVehiclePK that = (DriverVehiclePK) o;
        return Objects.equals(driver, that.driver) &&
                Objects.equals(vehicle, that.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, vehicle);
    }
}
