package com.arielsonsantos.sgco.rentalvehiclecontainerdriver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalVehicleContainerDriverRepository extends JpaRepository<RentalVehicleContainerDriver, Integer> {
}
