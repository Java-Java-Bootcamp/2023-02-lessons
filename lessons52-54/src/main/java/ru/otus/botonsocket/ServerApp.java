package ru.otus.botonsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

    public static void main(String[] args) {
        //Серверная часть, настраиваем сервер на заданные порт
        try (ServerSocket serverSocket = new ServerSocket(1234)) {

            System.out.println("Cервер запущен, ожидает подключения клиентов...");
            //Получен и принимается запрос на подключение от клиентского приложения
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился!");

            //чтение из сокета
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //запись в сокет
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            //бесконечно ожидаем команд от клиента
            while(true) {
                //Получаем сообщение от подключившегося клиента, считываем его, сохраняем в String
                String requestFromClient = dataInputStream.readUTF();
                // если сообщение == close, выходим из бесконечного цикла -->
                if("close".equals(requestFromClient)) break;
                // если сообщение == show polls, отправляем на клиент содержимое мапы с опросами
                else if("show polls".equals(requestFromClient)){

                }
                // если сообщение == create poll, создаем опрос по вопросам и вариантам ответа и сохраняем в мапу
                else if("create poll".equals(requestFromClient)){

                }

                System.out.println("Клиент прислал сообщение: " + requestFromClient);
                // Возвращаем обратно клиенту сообщение, которое он присылал
                dataOutputStream.writeUTF("Ответ сервера: " + requestFromClient);
            }
            // --> закрываем соединение с клиентом, выключаем сервер
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
