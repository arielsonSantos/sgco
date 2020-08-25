package com.arielsonsantos.sgco.drivervehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverVehicleRepository extends JpaRepository<DriverVehicle, Integer> {
}
