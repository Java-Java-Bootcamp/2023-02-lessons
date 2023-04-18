package jpa73;

import jpa73.model.Client;
import jpa73.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DataInitialization implements CommandLineRunner {
	private final ClientRepository clientRepository;

	public DataInitialization(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	@Transactional
	public void run(String... args) {
		var client1 = new Client("Ivanov", null, 18);
		var client2 = new Client("Petrov", null, 37);
		var client3 = new Client("Golovanov", null, 28);
		var client4 = new Client("Petrov", null, 56);

		clientRepository.add(client1);
		clientRepository.add(client2);
		clientRepository.add(client3);
		clientRepository.add(client4);
	}
}
