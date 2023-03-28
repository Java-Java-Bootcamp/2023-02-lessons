package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PingClient implements AutoCloseable {
    private DataInputStream in;

    private DataOutputStream out;


    public PingClient(InputStream in, OutputStream outputStream) {
        this.in = new DataInputStream(new BufferedInputStream(in));
        out = new DataOutputStream(new BufferedOutputStream(outputStream));
    }

    public void sendMessage(String message, String message2) throws IOException {
        out.writeUTF(message);
        out.writeUTF(message2);
        out.flush();

        String answer = in.readUTF();
        System.out.println("server answer " + answer);
    }

    @Override
    public void close() throws Exception {
        in.close();
        out.close();
    }
}
