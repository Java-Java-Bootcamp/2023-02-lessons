package ru.otus.lesson_46.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PingServer implements AutoCloseable {

    private final ServerSocket sSocket;

    public PingServer(int port) throws IOException {
        this.sSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        Socket openedSocket = sSocket.accept();

        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(openedSocket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(openedSocket.getOutputStream()))
        ) {
            String inputMessage = in.readLine();
            System.out.println("get message " + inputMessage);

            out.write("pong: " + inputMessage + "\n");
            out.flush();
        }
    }

    @Override
    public void close() throws Exception {
        sSocket.close();
    }
}
