package com.arielsonsantos.sgco.rentalcontainers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalContainersRepository extends JpaRepository<RentalContainers, Integer> {
}
