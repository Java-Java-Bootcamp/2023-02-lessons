package com.example.demo.client.creator;

import com.example.demo.client.ClientRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty("client-creator.enabled")
@EnableConfigurationProperties(ClientCreatorProperties.class)
public class ClientCreator {
	public ClientCreator(ClientRepository repository, ClientCreatorProperties properties) {
		if (properties.getClients() != null)
			properties.getClients().forEach(repository::save);
	}
}
