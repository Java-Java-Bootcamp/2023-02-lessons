package ru.otus.botonsocket.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import ru.otus.botonsocket.dto.PollDto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import ru.otus.botonsocket.utils.Commands;

public class ServerApp {

    public static void main(String[] args) {
        //Серверная часть, настраиваем сервер на заданные порт
        try (ServerSocket serverSocket = new ServerSocket(1234)) {

            System.out.println("Cервер запущен, ожидает подключения клиентов...");
            //Получен и принимается запрос на подключение от клиентского приложения
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился!");

            //чтение из сокета
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            //запись в сокет
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            var pool = new PoolOfPolls();

            //бесконечно ожидаем команд от клиента
            while (true) {
                /*
                 * Request -> Response
                 *
                 * 1. Получить сообщение из InputStream
                 * 2. Десериализовать сообщение из, например, json в Dto объект
                 * 3. Обработать запрос
                 * 4. Сформировать Dto объект ответа
                 * 5. Сериализовать в, например, json
                 * 6. Записать в OutputStream
                 */

                //Получаем сообщение от подключившегося клиента, считываем его, сохраняем в String
                String requestFromClient = dataInputStream.readUTF();
                System.out.println("Клиент прислал сообщение: " + requestFromClient);

                // если сообщение == close, выходим из бесконечного цикла -->
                if (Commands.CLOSE.equals(requestFromClient)) {
                    break;
                }
                // если сообщение == show polls, отправляем на клиент содержимое мапы с опросами
                else if (Commands.SHOW_POLLS.equals(requestFromClient)) {
                    showPolls(dataInputStream, dataOutputStream, pool);
                }
                // если сообщение == create poll, создаем опрос по вопросам и вариантам ответа и сохраняем в мапу
                else if (Commands.CREATE_POLL.equals(requestFromClient)) {
                    createPoll(dataInputStream, dataOutputStream, pool);
                }
                // если сообщение == do poll, обрабатываем голос
                else if (Commands.DO_POLL.equals(requestFromClient)) {
                    doPoll(dataInputStream, dataOutputStream, pool);
                }

            }
            // --> закрываем соединение с клиентом, выключаем сервер
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Формат запроса:
     * Вопрос Кол-воОтветов Ответ1 ... ОтветN
     *
     * Формат ответа:
     * OK
     */
    private static void createPoll(DataInputStream dataInputStream,
        DataOutputStream dataOutputStream,
        PoolOfPolls pool) throws IOException {

        var question = dataInputStream.readUTF();

        // прочитаем ответы
        var count = dataInputStream.readInt();
        var answers = new ArrayList<String>(count);
        for (int i = 0; i < count; ++i) {
            answers.add(dataInputStream.readUTF());
        }

        pool.addPoll(new PollDto(question, answers));

        // Возвращаем обратно клиенту OK
        dataOutputStream.writeUTF("OK");
        dataOutputStream.flush();

        System.out.println("Создали опрос: " + question + ": " + answers);
    }

    /**
     * Формат запроса:
     * -
     *
     * Формат ответа:
     * Кол-воОпросов IDВопроса Вопрос Кол-воОтветов Ответ1 ... ОтветN Голоса1 ... ГолосаN  СледующийВопрос ...
     *
     * Опросов нет: 0
     * Один опрос: 1   1 Q1 2 A1 A2 5 7
     * Два опроса: 2   1 Q1 2 A1 A2 5 7  2 Q2 3 A1 A2 A3 0 0 4
     */
    private static void showPolls(DataInputStream dataInputStream,
        DataOutputStream dataOutputStream,
        PoolOfPolls pool) throws IOException {

        System.out.println("Возвращаем опросы...");

        var polls = pool.getPolls();
        dataOutputStream.writeInt(polls.size());

        for (var poll: polls) {
            dataOutputStream.writeInt(poll.getId());
            dataOutputStream.writeUTF(poll.getPollQuestion());
            dataOutputStream.writeInt(poll.getListOfOptions().size());
            for (var answer: poll.getListOfOptions())
                dataOutputStream.writeUTF(answer);
            for (var count: poll.getListOfVotes())
                dataOutputStream.writeInt(count);
        }

        dataOutputStream.flush();
    }

    /**
     * Формат запроса:
     * IDопроса НомерОтвета
     *
     * Формат ответа:
     * OK
     */
    private static void doPoll(DataInputStream dataInputStream,
        DataOutputStream dataOutputStream,
        PoolOfPolls pool) throws IOException {

        var id = dataInputStream.readInt();
        var answerNo = dataInputStream.readInt();

        System.out.println("Пользователь проголосовал: " + id + ": " + answerNo);

        pool.vote(id, answerNo);

        dataOutputStream.writeUTF("OK");
        dataOutputStream.flush();
    }

}
