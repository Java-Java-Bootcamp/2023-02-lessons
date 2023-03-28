package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ClientServlet extends HttpServlet {
    private final ClientRepository clientRepository = new ClientinMemoryRepository();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> clients = clientRepository.findAll();
        String body = mapper.writeValueAsString(clients);
        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getWriter().println(body);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader reader = req.getReader();
            while ((content = reader.readLine()) != null) {
                stringBuilder.append(content);
            }
            Client client = mapper.readValue(stringBuilder.toString(), Client.class);

            clientRepository.save(client);
            resp.setStatus(201);
        } catch (Exception e) {
            resp.setStatus(500);
            resp.getWriter().write("Exception: " + e.getMessage());
        }

    }
}
