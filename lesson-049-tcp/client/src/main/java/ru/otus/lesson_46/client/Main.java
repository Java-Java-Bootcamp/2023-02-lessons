package ru.otus.lesson_46.client;

import ru.otus.lesson_46.client.models.MathClient;
import ru.otus.lesson_46.client.models.PingClient;

import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        System.out.println("start client");
        try (Socket socket = new Socket("localhost", 8081)) {
//            PingClient client = new PingClient(socket.getInputStream(), socket.getOutputStream());
//            client.sendMessage("test messsage");

            MathClient client = new MathClient(socket.getInputStream(), socket.getOutputStream());
            client.run();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
