package org.example;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try (Socket socket = new Socket("localhost", 8881);
             PingClient pingClient = new PingClient(socket.getInputStream(), socket.getOutputStream())) {
            Scanner scanner = new Scanner(System.in);
            while(true) {
                String input = scanner.nextLine();
                String input2 = scanner.nextLine();
                pingClient.sendMessage(input, input2);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
