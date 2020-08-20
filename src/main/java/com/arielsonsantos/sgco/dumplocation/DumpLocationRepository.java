package com.arielsonsantos.sgco.dumplocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DumpLocationRepository extends JpaRepository<DumpLocation, Integer> {
}
