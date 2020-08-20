package com.arielsonsantos.sgco;

import com.arielsonsantos.sgco.vehicle.Vehicle;
import com.arielsonsantos.sgco.vehicle.VehicleService;
import com.arielsonsantos.sgco.vehicle.VehicleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	VehicleService vehicleService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Vehicle v1 = new Vehicle("Mercedes", "Mercedes 1", VehicleStatus.ATIVO);
		Vehicle v2 = new Vehicle("Volvo", "Volvo 1", VehicleStatus.MANUTENCAO);

		vehicleService.saveAll(Arrays.asList(v1, v2));

	}
}
