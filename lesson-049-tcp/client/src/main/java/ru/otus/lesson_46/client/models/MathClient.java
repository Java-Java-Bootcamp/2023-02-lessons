package ru.otus.lesson_46.client.models;

import java.io.*;
import java.util.Scanner;

public class MathClient implements AutoCloseable {

    private final DataInputStream in;
    private final DataOutputStream out;
    private final Scanner scanner;

    public MathClient(InputStream in, OutputStream out) {
        this.in = new DataInputStream(new BufferedInputStream(in));
        this.out = new DataOutputStream(new BufferedOutputStream(out));
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        try {
            while (true) {
                System.out.println("""
                        0 - выход
                        1 - получить список доступных команд
                        2 - выполнить команду
                        """);

                var input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 0:
                        return;
                    case 1:
                        out.writeUTF("commands");
                        out.flush();
                        System.out.println("доступные команды:\n" + in.readUTF() + "\n");
                        break;
                    case 2:
                        System.out.println("введите команду ");
                        String command = scanner.nextLine();

                        System.out.println("введите первый операнд ");
                        int item1 = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("введите второй операнд ");
                        int item2 = scanner.nextInt();
                        scanner.nextLine();

                        out.writeUTF(command);
                        out.writeInt(item1);
                        out.writeInt(item2);
                        out.flush();

                        System.out.println("результат: " + in.readInt());

                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        in.close();
        out.close();
    }
}
