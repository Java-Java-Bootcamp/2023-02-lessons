package com.example.demo.client;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClientinMemoryRepository implements ClientRepository{
    private List<Client> db = new ArrayList<>();

    public ClientinMemoryRepository() {
        System.out.println("ClientMemoryRepository created");
    }

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
