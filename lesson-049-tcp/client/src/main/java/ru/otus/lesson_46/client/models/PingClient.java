package ru.otus.lesson_46.client.models;

import java.io.*;

public class PingClient implements AutoCloseable {

    private final BufferedReader in;
    private final BufferedWriter out;

    public PingClient(InputStream in, OutputStream out) {
        this.in = new BufferedReader(new InputStreamReader(in));
        this.out = new BufferedWriter(new OutputStreamWriter(out));
    }

    public void sendMessage(String message) throws Exception {
        out.write(message + "\n");
        out.flush();

        String answer = in.readLine();
        System.out.println("server answer " + answer);
    }

    @Override
    public void close() throws Exception {
        in.close();
        out.close();
    }
}
