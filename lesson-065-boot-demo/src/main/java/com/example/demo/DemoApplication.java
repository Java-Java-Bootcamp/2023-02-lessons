package com.example.demo;

import com.example.demo.client.Client;
import com.example.demo.client.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(DemoApplication.class, args);
		System.out.println("Count: " + ctx.getBeanDefinitionCount());
		System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));

		ClientRepository repository = ctx.getBean(ClientRepository.class);
		repository.save(new Client(1, "Ivan", "Ivanov", 33));
		repository.save(new Client(2, "Petr", "Petrov", 33));
	}

}
