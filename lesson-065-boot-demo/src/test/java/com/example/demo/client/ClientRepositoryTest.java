package com.example.demo.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ClientRepositoryTest {

	private final ClientRepository repository = new ClientinMemoryRepository();
	private final Client
			client1 = new Client(0, "Ivan", "Ivanov", 33),
			client2 = new Client(1, "Petr", "Petrov", 33);

	@Test
	void addClient() {
		repository.save(client1);
		repository.save(client2);
		assertThat(repository.findAll()).containsExactly(client1, client2);
	}
}