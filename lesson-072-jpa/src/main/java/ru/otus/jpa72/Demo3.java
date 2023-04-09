package ru.otus.jpa72;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.otus.jpa72.model.Client;
import ru.otus.jpa72.model.Order;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class Demo3 implements CommandLineRunner {
	private final EntityManager entityManager;

	public Demo3(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void run(String... args) {
		System.out.println(">>>>>>>>>>>>>>> run");
		var client = entityManager.find(Client.class, 1l);

		var order = new Order();
		order.setClient(client);
		//order.setItems(List.of(new OrderItem("phone", 1, 1), new OrderItem("tv", 2, 1)));

		entityManager.persist(order);
		entityManager.flush();
		entityManager.clear();

		System.out.println("==================================");
		var fromDB = entityManager.find(Order.class, order.getId());
		System.out.println(">> received");
		System.out.println(fromDB);

		//entityManager.remove(entityManager.getReference(Order.class, order.getId())); // обратите внимание, что получен Client


		//fromDB.getItems().remove(1);

	}
}
