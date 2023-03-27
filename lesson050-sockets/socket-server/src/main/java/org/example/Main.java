package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8881)) {
            while (true) {
                Socket accept = serverSocket.accept();
                try(ClientHandler clientHandler = new ClientHandler(accept)) {
                    clientHandler.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
