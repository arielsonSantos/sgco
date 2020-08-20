package com.arielsonsantos.sgco.containertype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerTypeRepository extends JpaRepository<ContainerType, Integer> {
}
