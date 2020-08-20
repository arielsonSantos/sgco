package com.arielsonsantos.sgco.rentalvehiclecontainerdriver;

import com.arielsonsantos.sgco.container.Container;
import com.arielsonsantos.sgco.driver.Driver;
import com.arielsonsantos.sgco.rental.Rental;
import com.arielsonsantos.sgco.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class RentalVehicleContainerDriver implements Serializable {

    @EmbeddedId
    private RentalVehicleContainerDriverPK id = new RentalVehicleContainerDriverPK();

    public RentalVehicleContainerDriver() {
    }

    public RentalVehicleContainerDriver(Rental locacao, Vehicle veiculo, Container cacamba, Driver motorista, RentalVehicleContainerDriverStatus status) {
        id.setRental(locacao);
        id.setVeiculo(veiculo);
        id.setCacamba(cacamba);
        id.setMotorista(motorista);
        id.setStatus(status);
    }

    @JsonIgnore
    public Rental getRental() {
        return id.getRental();
    }

    public void setRental(Rental locacao) {
        id.setRental(locacao);
    }

    public Vehicle getVehicle() {
        return id.getVeiculo();
    }

    public void setRental(Vehicle veiculo) {
        id.setVeiculo(veiculo);
    }

    public Container getContainer() {
        return id.getCacamba();
    }

    public void setContainer(Container cacamba) {
        id.setCacamba(cacamba);
    }

    public Driver getDriver() {
        return id.getMotorista();
    }

    public void setDriver(Driver motorista) {
        id.setMotorista(motorista);
    }

    public RentalVehicleContainerDriverStatus getStatus() {
        return id.getStatus();
    }

    public void setStatus(RentalVehicleContainerDriverStatus status) {
        id.setStatus(status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentalVehicleContainerDriver)) return false;
        RentalVehicleContainerDriver that = (RentalVehicleContainerDriver) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
