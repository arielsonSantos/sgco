package com.arielsonsantos.sgco.drivervehicle;

import com.arielsonsantos.sgco.driver.Driver;
import com.arielsonsantos.sgco.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class DriverVehicle implements Serializable {

    @EmbeddedId
    private DriverVehiclePK id = new DriverVehiclePK();

    public DriverVehicle() {
    }

    public DriverVehicle(Driver motorista, Vehicle veiculo) {
        id.setDriver(motorista);
        id.setVehicle(veiculo);
    }

    @JsonIgnore
    public Driver getDriver() {
        return id.getDriver();
    }

    public void setDriver(Driver motorista) {
        id.setDriver(motorista);
    }

    public Vehicle getVehicle() {
        return id.getVehicle();
    }

    public void setVehicle(Vehicle veiculo) {
        id.setVehicle(veiculo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DriverVehicle)) return false;
        DriverVehicle that = (DriverVehicle) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
