package com.arielsonsantos.sgco.rentalvehiclecontainerdriver;

import com.arielsonsantos.sgco.container.Container;
import com.arielsonsantos.sgco.driver.Driver;
import com.arielsonsantos.sgco.rental.Rental;
import com.arielsonsantos.sgco.vehicle.Vehicle;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RentalVehicleContainerDriverPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle veiculo;

    @ManyToOne
    @JoinColumn(name = "container_id")
    private Container cacamba;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver motorista;

    private RentalVehicleContainerDriverStatus status;

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Vehicle getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Vehicle veiculo) {
        this.veiculo = veiculo;
    }

    public Container getCacamba() {
        return cacamba;
    }

    public void setCacamba(Container cacamba) {
        this.cacamba = cacamba;
    }

    public Driver getMotorista() {
        return motorista;
    }

    public void setMotorista(Driver motorista) {
        this.motorista = motorista;
    }

    public RentalVehicleContainerDriverStatus getStatus() {
        return status;
    }

    public void setStatus(RentalVehicleContainerDriverStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentalVehicleContainerDriverPK)) return false;
        RentalVehicleContainerDriverPK that = (RentalVehicleContainerDriverPK) o;
        return Objects.equals(rental, that.rental) &&
                Objects.equals(veiculo, that.veiculo) &&
                Objects.equals(cacamba, that.cacamba) &&
                Objects.equals(motorista, that.motorista) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rental, veiculo, cacamba, motorista, status);
    }
}
