package jpa73.controller;

import jpa73.model.Client;
import jpa73.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/client")
@Transactional
public class ClientController {
	private final ClientRepository repository;
	private final CrudClientRepository crudRepository;
	private final PagingClientRepository pagingRepository;

	public ClientController(ClientRepository repository, CrudClientRepository crudRepository, PagingClientRepository pagingRepository) {
		this.repository = repository;
		this.crudRepository = crudRepository;
		this.pagingRepository = pagingRepository;
	}

	@GetMapping
	public Iterable<Client> getAllClients() {
//		return repository.findAll();
		return pagingRepository.findAll(PageRequest.of(1, 2, Sort.by(Sort.Order.desc("fullName"))));
	}

	@GetMapping("/search")
	public List<Client> getAllClients(@RequestParam String fullName) {
		return pagingRepository.findByFullName(fullName, Client.class);
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
