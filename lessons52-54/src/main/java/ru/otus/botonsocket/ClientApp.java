package ru.otus.botonsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

    public static void main(String[] args) {
        //создать сокет
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            // Клиент пытается подключиться на сервер по адресу localhost, по порту 1234
            socket = new Socket("localhost",1234);
            //чтение из сокета
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //запись в сокет
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while(true) {
                System.out.println("Введите команду...");
                String requestFromUser = scanner.nextLine();
                // Полученную от пользователя строки отправляем на Сервер
                dataOutputStream.writeUTF(requestFromUser);
                // если пользователь ввел close
                if("close".equals(requestFromUser)) break; // выходим из цикла --->

                // принимаем ответ от сервера
                System.out.println("Сервер ответил: " + dataInputStream.readUTF());
            }
            ///  ----->
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //  --->
            //закрыть сокет
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
