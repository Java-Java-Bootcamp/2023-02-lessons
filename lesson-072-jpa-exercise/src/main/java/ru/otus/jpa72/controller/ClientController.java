package ru.otus.jpa72.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.jpa72.model.Client;
import ru.otus.jpa72.repository.ClientRepository;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/client")
@Transactional
public class ClientController {
	private final ClientRepository repository;

	public ClientController(ClientRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Client> getAllClients() {
		return repository.findAll();
	}

	@PostMapping
	public Client addClient(Client client) {
		repository.add(client);
		return client;
	}

	@PutMapping
	public void updateClient(Client client) {
		repository.merge(client);
	}

	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable long id) {
		repository.delete(id);
	}

}
