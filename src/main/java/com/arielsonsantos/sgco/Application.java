package com.arielsonsantos.sgco;

import com.arielsonsantos.sgco.address.Address;
import com.arielsonsantos.sgco.address.AddressRepository;
import com.arielsonsantos.sgco.client.Client;
import com.arielsonsantos.sgco.client.ClientRepository;
import com.arielsonsantos.sgco.client.ClientStatus;
import com.arielsonsantos.sgco.container.Container;
import com.arielsonsantos.sgco.container.ContainerRepository;
import com.arielsonsantos.sgco.container.ContainerStatus;
import com.arielsonsantos.sgco.containertype.ContainerType;
import com.arielsonsantos.sgco.containertype.ContainerTypeRepository;
import com.arielsonsantos.sgco.driver.Driver;
import com.arielsonsantos.sgco.driver.DriverRepository;
import com.arielsonsantos.sgco.driver.DriverStatus;
import com.arielsonsantos.sgco.dumplocation.DumpLocation;
import com.arielsonsantos.sgco.dumplocation.DumpLocationRepository;
import com.arielsonsantos.sgco.rental.Rental;
import com.arielsonsantos.sgco.rental.RentalRepository;
import com.arielsonsantos.sgco.rental.RentalStatus;
import com.arielsonsantos.sgco.rentalvehiclecontainerdriver.RentalVehicleContainerDriver;
import com.arielsonsantos.sgco.rentalvehiclecontainerdriver.RentalVehicleContainerDriverRepository;
import com.arielsonsantos.sgco.rentalvehiclecontainerdriver.RentalVehicleContainerDriverStatus;
import com.arielsonsantos.sgco.vehicle.Vehicle;
import com.arielsonsantos.sgco.vehicle.VehicleRepository;
import com.arielsonsantos.sgco.vehicle.VehicleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	DumpLocationRepository dumpLocationRepository;

	@Autowired
	RentalRepository rentalRepository;

	@Autowired
	ContainerTypeRepository containerTypeRepository;

	@Autowired
	ContainerRepository containerRepository;

	@Autowired
	DriverRepository driverRepository;

	@Autowired
	RentalVehicleContainerDriverRepository rentalVehicleContainerDriverRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Vehicle v1 = new Vehicle("Mercedes", "Mercedes 1", VehicleStatus.ATIVO);
		Vehicle v2 = new Vehicle("Volvo", "Volvo 1", VehicleStatus.MANUTENCAO);

		vehicleRepository.saveAll(Arrays.asList(v1, v2));

		Client c1 = new Client("Arielson", "Santos", new Date(), "Observação", "09718582924", "129337036", "arielsonelias@gmail.com", ClientStatus.ATIVO);
		Client c2 = new Client("Carol", "Santos", new Date(), "Observação 2", "11182014933", "123456789", "carolayne.goncalvesrosa@gmail.com", ClientStatus.INADIMPLENTE);

		clientRepository.saveAll(Arrays.asList(c1, c2));

		Address a1 = new Address(c1, "87050210", "336");
		Address a2 = new Address(c2, "87050160", "552");

		addressRepository.saveAll(Arrays.asList(a1, a2));

		c1.getEnderecos().addAll(Arrays.asList(a1, a2));
		c2.getEnderecos().addAll(Arrays.asList(a1, a2));

		clientRepository.saveAll(Arrays.asList(c1, c2));

		DumpLocation d1 = new DumpLocation("Pedreira", 50.0D);
		DumpLocation d2 = new DumpLocation("Outro lugar", 100.0D);

		dumpLocationRepository.saveAll(Arrays.asList(d1, d2));

		Rental r1 = new Rental(new Date(), new Date(), 100.0D, c1, (Address) c1.getEnderecos().toArray()[0], RentalStatus.AGUARDANDO_ENTREGA);
		Rental r2 = new Rental(new Date(), new Date(), 200.0D, c2, (Address) c2.getEnderecos().toArray()[1], RentalStatus.AGUARDANDO_RETIRADA);

		r1.getLocaisDespejo().addAll(Arrays.asList(d1, d2));
		r2.getLocaisDespejo().add(d2);

		rentalRepository.saveAll(Arrays.asList(r1, r2));

		ContainerType t1 = new ContainerType("Grande", 100.0D);
		ContainerType t2 = new ContainerType("Média", 50.0D);

		containerTypeRepository.saveAll(Arrays.asList(t1, t2));

		Container ca1 = new Container(12, t1, ContainerStatus.DISPONIVEL);
		Container ca2 = new Container(13, t2, ContainerStatus.LOCADA);

		containerRepository.saveAll(Arrays.asList(ca1, ca2));

		Driver m1 = new Driver("Celso", DriverStatus.PATIO);
		Driver m2 = new Driver("Odilon", DriverStatus.TRECHO);

		driverRepository.saveAll(Arrays.asList(m1, m2));

		RentalVehicleContainerDriver rel1 = new RentalVehicleContainerDriver(r1, v1, ca1, m1, RentalVehicleContainerDriverStatus.ENTREGA);
		RentalVehicleContainerDriver rel2 = new RentalVehicleContainerDriver(r1, v2, ca2, m2, RentalVehicleContainerDriverStatus.ENTREGA);
		RentalVehicleContainerDriver rel3 = new RentalVehicleContainerDriver(r1, v1, ca1, m1, RentalVehicleContainerDriverStatus.RETIRADA);
		RentalVehicleContainerDriver rel4 = new RentalVehicleContainerDriver(r2, v2, ca2, m1, RentalVehicleContainerDriverStatus.ENTREGA);

		rentalVehicleContainerDriverRepository.saveAll(Arrays.asList(rel1, rel2, rel3, rel4));
	}
}
