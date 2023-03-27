package ru.otus.lesson_46.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements AutoCloseable {

    private final DataInputStream in;
    private final DataOutputStream out;

    private Socket socket;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        this.out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    public void start() throws IOException {
        while (true) {
            String command = in.readUTF();
            switch (command) {
                case "commands":
                    out.writeUTF("add\nsubtract\nmultiply\ndivide");
                    break;
                default:
                    int item1 = in.readInt();
                    int item2 = in.readInt();
                    out.writeInt(calculation(command, new int[]{item1, item2}));
                    break;
            }
            out.flush();
        }
    }

    @Override
    public void close() throws Exception {
        in.close();
        out.close();
    }

    private int calculation(String operation, int[] operands) {
        return switch (operation) {
            case "add" -> operands[0] + operands[1];
            case "subtract" -> operands[0] - operands[1];
            case "multiply" -> operands[0] * operands[1];
            case "divide" -> operands[0] / operands[1];
            default -> 0;
        };
    }
}
