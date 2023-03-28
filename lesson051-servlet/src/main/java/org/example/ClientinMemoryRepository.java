package org.example;

import java.util.ArrayList;
import java.util.List;

public class ClientinMemoryRepository implements ClientRepository{
    private List<Client> db = new ArrayList<>();

    @Override
    public List<Client> findAll() {
        return db;
    }

    @Override
    public Client save(Client client) {
        if(client != null) {
            client.setId(db.size());
            db.add(client);
            return client;
        }
        return client;
    }
}
