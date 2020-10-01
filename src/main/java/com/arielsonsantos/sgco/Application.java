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
import com.arielsonsantos.sgco.phone.Phone;
import com.arielsonsantos.sgco.phone.PhoneRepository;
import com.arielsonsantos.sgco.rental.Rental;
import com.arielsonsantos.sgco.rental.RentalRepository;
import com.arielsonsantos.sgco.rental.RentalStatus;
import com.arielsonsantos.sgco.rentalcontainerhistory.RentalContainerHistory;
import com.arielsonsantos.sgco.rentalcontainerhistory.RentalContainerHistoryRepository;
import com.arielsonsantos.sgco.rentalcontainerhistory.RentalContainerHistoryStatus;
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
	RentalContainerHistoryRepository rentalContainerHistoryRepository;

	@Autowired
	PhoneRepository phoneRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {

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

		Rental rental1 = new Rental(new Date(), new Date(), arielson, vidal, RentalStatus.AGUARDANDO_ENTREGA);
		Rental rental2 = new Rental(new Date(), new Date(), carol, barroso, RentalStatus.AGUARDANDO_RETIRADA);
		rentalRepository.saveAll(Arrays.asList(rental1, rental2));

		// Relações:

		// Cliente - Endereços e Telefones
		carol.getAddresses().add(barroso);
		arielson.getAddresses().addAll(Arrays.asList(vidal, barroso));
		carol.getPhones().add(phoneCarol);
		arielson.getPhones().addAll(Arrays.asList(phoneFrancisca, phoneCarol, phoneJoao));
		clientRepository.saveAll(Arrays.asList(carol, arielson));

		// Locação - Local de despejo
		rental1.getDumpLocations().addAll(Arrays.asList(pedreira, outroLugar));
		rental2.getDumpLocations().add(outroLugar);
		rentalRepository.saveAll(Arrays.asList(rental1, rental2));

		// Locação - Caçambas
		RentalContainerHistory rel1 = new RentalContainerHistory(rental1, celso, mercedes, container1, new Date(), RentalContainerHistoryStatus.ENTREGA);
		RentalContainerHistory rel2 = new RentalContainerHistory(rental1, odilon, volvo, container2, new Date(), RentalContainerHistoryStatus.ENTREGA);
		RentalContainerHistory rel3 = new RentalContainerHistory(rental1, celso, mercedes, container1, new Date(), RentalContainerHistoryStatus.RETIRADA);
		RentalContainerHistory rel4 = new RentalContainerHistory(rental1, odilon, mercedes, container2, new Date(), RentalContainerHistoryStatus.RETIRADA);
		RentalContainerHistory rel5 = new RentalContainerHistory(rental2, odilon, mercedes, container1, new Date(), RentalContainerHistoryStatus.ENTREGA);
		rentalContainerHistoryRepository.saveAll(Arrays.asList(rel1, rel2, rel3, rel4, rel5));
	}
}
