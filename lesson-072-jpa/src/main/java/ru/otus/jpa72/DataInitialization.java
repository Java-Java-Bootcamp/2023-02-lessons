package ru.otus.jpa72;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import ru.otus.jpa72.model.Client;
import ru.otus.jpa72.repository.ClientRepository;

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
		var client1 = new Client("Ivanov", null);
		var client2 = new Client("Petrov", null);

		clientRepository.add(client1);
		clientRepository.add(client2);
	}
}
