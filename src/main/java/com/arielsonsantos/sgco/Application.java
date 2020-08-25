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
import com.arielsonsantos.sgco.drivervehicle.DriverVehicle;
import com.arielsonsantos.sgco.drivervehicle.DriverVehicleRepository;
import com.arielsonsantos.sgco.dumplocation.DumpLocation;
import com.arielsonsantos.sgco.dumplocation.DumpLocationRepository;
import com.arielsonsantos.sgco.phone.Phone;
import com.arielsonsantos.sgco.phone.PhoneRepository;
import com.arielsonsantos.sgco.rental.Rental;
import com.arielsonsantos.sgco.rental.RentalRepository;
import com.arielsonsantos.sgco.rental.RentalStatus;
import com.arielsonsantos.sgco.rentalcontainers.RentalContainers;
import com.arielsonsantos.sgco.rentalcontainers.RentalContainersRepository;
import com.arielsonsantos.sgco.rentalcontainers.RentalContainersStatus;
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
	RentalContainersRepository rentalContainersRepository;

	@Autowired
	DriverVehicleRepository driverVehicleRepository;

	@Autowired
	PhoneRepository phoneRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Endereços
		Address vidal = new Address("87050210", "336");
		Address barroso = new Address("87050160", "552");
		addressRepository.saveAll(Arrays.asList(vidal, barroso));

		// Telefones
		Phone phoneCarol = new Phone("44", "998553387");
		Phone phoneJoao = new Phone("41", "997146708");
		Phone phoneFrancisca = new Phone("44", "997146734");
		phoneRepository.saveAll(Arrays.asList(phoneCarol, phoneJoao, phoneFrancisca));

		// Clientes
		Client arielson = new Client("Arielson", "Santos", new Date(), "Observação", "09718582924", "129337036", "arielsonelias@gmail.com", ClientStatus.ATIVO);
		Client carol = new Client("Carol", "Santos", new Date(), "Observação 2", "11182014933", "123456789", "carolayne.goncalvesrosa@gmail.com", ClientStatus.INADIMPLENTE);
		clientRepository.saveAll(Arrays.asList(arielson, carol));

		// Tipo de caçambas
		ContainerType grande = new ContainerType("Grande", 100.0D);
		ContainerType media = new ContainerType("Média", 50.0D);
		containerTypeRepository.saveAll(Arrays.asList(grande, media));

		 // Caçambas
		Container container1 = new Container(12, grande, ContainerStatus.DISPONIVEL);
		Container container2 = new Container(13, media, ContainerStatus.LOCADA);
		containerRepository.saveAll(Arrays.asList(container1, container2));

		// Veículos
		Vehicle mercedes = new Vehicle("Mercedes", "Mercedes 1", VehicleStatus.ATIVO);
		Vehicle volvo = new Vehicle("Volvo", "Volvo 1", VehicleStatus.MANUTENCAO);
		vehicleRepository.saveAll(Arrays.asList(mercedes, volvo));

		// Locais de despejo
		DumpLocation pedreira = new DumpLocation("Pedreira", 50.0D);
		DumpLocation outroLugar = new DumpLocation("Outro lugar", 100.0D);
		dumpLocationRepository.saveAll(Arrays.asList(pedreira, outroLugar));

		// Motoristas
		Driver celso = new Driver("Celso", DriverStatus.PATIO);
		Driver odilon = new Driver("Odilon", DriverStatus.TRECHO);
		driverRepository.saveAll(Arrays.asList(celso, odilon));

		Rental rental1 = new Rental(new Date(), new Date(), 100.0D, arielson, vidal, RentalStatus.AGUARDANDO_ENTREGA);
		Rental rental2 = new Rental(new Date(), new Date(), 200.0D, carol, barroso, RentalStatus.AGUARDANDO_RETIRADA);
		rentalRepository.saveAll(Arrays.asList(rental1, rental2));

		// Relações:

		// Cliente - Endereços
		vidal.getClients().addAll(Arrays.asList(arielson, carol));
		barroso.getClients().addAll(Arrays.asList(arielson, carol));
		addressRepository.saveAll(Arrays.asList(vidal, barroso));

		// Cliente - Telefones
		carol.getPhones().add(phoneCarol);
		arielson.getPhones().addAll(Arrays.asList(phoneFrancisca, phoneJoao));
		clientRepository.saveAll(Arrays.asList(carol, arielson));

		// Motorista - Veículo
		DriverVehicle celsoMercedes = new DriverVehicle(celso, mercedes);
		DriverVehicle celsoVolvo = new DriverVehicle(celso, volvo);
		DriverVehicle odilonVolvo = new DriverVehicle(odilon, volvo);
		DriverVehicle odilonMercedes = new DriverVehicle(odilon, mercedes);
		driverVehicleRepository.saveAll(Arrays.asList(celsoMercedes, celsoVolvo, odilonMercedes, odilonVolvo));

		// Locação - Local de despejo
		rental1.getDumpLocations().addAll(Arrays.asList(pedreira, outroLugar));
		rental2.getDumpLocations().add(outroLugar);
		rentalRepository.saveAll(Arrays.asList(rental1, rental2));

		// Locação - Caçambas
		RentalContainers rel1 = new RentalContainers(rental1, container1, RentalContainersStatus.ENTREGA);
		RentalContainers rel2 = new RentalContainers(rental1, container1, RentalContainersStatus.RETIRADA);
		RentalContainers rel3 = new RentalContainers(rental1, container2, RentalContainersStatus.ENTREGA);
		RentalContainers rel4 = new RentalContainers(rental1, container2, RentalContainersStatus.RETIRADA);
		RentalContainers rel5 = new RentalContainers(rental2, container1, RentalContainersStatus.ENTREGA);
		rentalContainersRepository.saveAll(Arrays.asList(rel1, rel2, rel3, rel4, rel5));
	}
}
