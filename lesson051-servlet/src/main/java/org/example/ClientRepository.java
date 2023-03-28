package org.example;

import java.util.List;

public interface ClientRepository {
    List<Client> findAll();

    Client save(Client client);
}
