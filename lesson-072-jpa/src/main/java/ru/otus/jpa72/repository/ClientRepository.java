package ru.otus.jpa72.repository;

import org.springframework.stereotype.Component;
import ru.otus.jpa72.model.Client;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ClientRepository {
	private final EntityManager entityManager;

	public ClientRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void add(Client client) {
		entityManager.persist(client);
	}

	public Client merge(Client client) {
		return entityManager.merge(client);
	}

	public Client getById(long id) {
		return entityManager.find(Client.class, id);
	}

	public void delete(long id) {
		entityManager.remove(entityManager.getReference(Client.class, id));
	}

	public List<Client> findAll() {
		return entityManager
				.createQuery("select c from Client c", Client.class)
				.getResultList();
	}
}
