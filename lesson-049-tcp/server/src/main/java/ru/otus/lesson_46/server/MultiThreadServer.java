package ru.otus.lesson_46.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer implements AutoCloseable {

    private final ServerSocket sSocket;

    public MultiThreadServer(int port) throws IOException {
        this.sSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        while (true) {
            Socket openedSocket = sSocket.accept();
            new ClientThread(openedSocket).start();
        }
    }

    @Override
    public void close() throws Exception {
        sSocket.close();
    }

    private class ClientThread extends Thread {
        private final Socket socket;

        ClientThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                ClientHandler handler = new ClientHandler(socket);
                handler.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
