package com.example.demo.client;

import java.util.List;

public interface ClientRepository {
    List<Client> findAll();

    Client save(Client client);
}
