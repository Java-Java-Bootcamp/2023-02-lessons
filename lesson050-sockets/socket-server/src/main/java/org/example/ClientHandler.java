package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements AutoCloseable {
    private DataInputStream in;

    private DataOutputStream out;

    private Socket socket;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    public  void start() throws IOException {
        while (true) {
            String message = in.readUTF();
            String message2 = in.readUTF();
            System.out.println("got message: " + message + " " + message2);
            if ("exit".equals(message)) {
                break;
            }
            out.writeUTF(message + " " + message2);
            out.flush();
        }
    }

    @Override
    public void close() throws Exception {
        in.close();
        out.close();
    }
}
