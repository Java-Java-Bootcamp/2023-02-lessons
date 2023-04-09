package ru.otus.jpa72;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.otus.jpa72.model.Client;
import ru.otus.jpa72.repository.ClientRepository;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Component
public class Demo1 implements CommandLineRunner {
	private final ClientRepository repository;
	private final Demo1Processor processor;

	public Demo1(ClientRepository repository, Demo1Processor processor) {
		this.repository = repository;
		this.processor = processor;
	}

	@Override
	public void run(String... args) throws Exception {
		var client = processor.step1();
		client.setPhone(BigInteger.valueOf(556677));

		processor.print(client.getId());

		client = processor.update(client.getId(), 987);
		client.setFullName("Xxx");
		processor.print(client.getId());

		//create();
	}
/*
	@Transactional
	public void create() {
		System.out.println("======================== create");
		var client = new Client("Sidorov", null);
		repository.add(client);
		client.setPhone(BigInteger.valueOf(11223344));

		processor.print(client.getId()); // как думаете, что будет распечатано?
	}*/



	@Component
	public static class Demo1Processor {
		private final ClientRepository repository;

		public Demo1Processor(ClientRepository repository) {
			this.repository = repository;
		}

		@Transactional
		public Client step1() {
			System.out.println("======================== step1");
			var client = new Client("Sidorov", null);
			repository.add(client);
			client.setPhone(BigInteger.valueOf(11223344));
			this.print(1);
			return client;
		}

		@Transactional
		public void print(long id) {
			System.out.println("======================== print");
			System.out.println(repository.getById(id)); // А что тут будет напечатано? Какой номер телефона?
		}

		@Transactional
		public Client update(long id, int phone) {
			System.out.println("======================== update");
			var client = repository.getById(id);
			client.setPhone(BigInteger.valueOf(phone));
			return client;
		}

		@Transactional
		public void step2() {
			var client = step1();
			client.setFullName("Vasechkin");
			print(client.getId()); // что будет распечатано? Ск?
		}
	}
}
