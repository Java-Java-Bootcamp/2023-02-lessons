package com.example.demo.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ClientRestControllerTest {
	@MockBean
	private ClientRepository repository;

	@Autowired
	private MockMvc mockMvc;

	private final Client
		client1 = new Client(0, "Ivan", "Ivanov", 33),
		client2 = new Client(1, "Petr", "Petrov", 33);

	@Test
	public void getAllClients() throws Exception {
		when(repository.findAll()).thenReturn(List.of(client1, client2));

		mockMvc.perform(MockMvcRequestBuilders.get("/client"))
						.andExpect(status().isOk())
								.andExpect(content().json("""
										[{"id":0,"name":"Ivan","secondName":"Ivanov","age":33},{"id":1,"name":"Petr","secondName":"Petrov","age":33}]"""));
	}

}