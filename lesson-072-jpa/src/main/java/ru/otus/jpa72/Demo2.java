package ru.otus.jpa72;

import org.springframework.boot.CommandLineRunner;
import org.springframework.transaction.support.TransactionOperations;
import ru.otus.jpa72.model.Client;
import ru.otus.jpa72.model.Order;

import javax.persistence.EntityManager;

//@Component
public class Demo2 implements CommandLineRunner {

	private final EntityManager entityManager;
	private final TransactionOperations transactionOperations;

	public Demo2(EntityManager entityManager, TransactionOperations transactionOperations) {
		this.entityManager = entityManager;
		this.transactionOperations = transactionOperations;
	}

	@Override
	public void run(String... args) {
		Order outer = transactionOperations.execute(status -> {
			System.out.println("================================== run");
			//var client = entityManager.find(Client.class, 1l);

			var client = new Client("Sidorov", null);
			entityManager.persist(client); // можно и без этой строки - см cascade

			var order = new Order();
			order.setClient(client);
			entityManager.persist(order);
			entityManager.flush();
			entityManager.clear();

			System.out.println("==================================");
			var fromDB = entityManager.find(Order.class, order.getId());
			System.out.println(">> received");
			System.out.println(fromDB);
			//fromDB.getClient().getFullName(); эксперименты с fetch LAZY

			return fromDB;
		});

		// System.out.println(">> outer");
		// System.out.println(outer); // эксперименты с fetch LAZY
	}
}
