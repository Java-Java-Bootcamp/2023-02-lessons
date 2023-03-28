package ru.otus.botonsocket.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ru.otus.botonsocket.dto.PollDto;
import ru.otus.botonsocket.utils.Commands;

public class ClientApp {

    public static void main(String[] args) throws Exception {
        //создать сокет
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket("localhost", 1234)) {
            // Клиент пытается подключиться на сервер по адресу localhost, по порту 1234
            //чтение из сокета
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            //запись в сокет
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            while (true) {
                System.out.println("Введите команду:");
                System.out.println("1 - создать опрос");
                System.out.println("2 - показать опросы");
                System.out.println("3 - проголосовать");
                System.out.println("0 - выход");
                String requestFromUser = scanner.nextLine();
                // Полученную от пользователя строки отправляем на Сервер
                switch (requestFromUser) {
                    case "1":
                        createPoll(scanner, dataInputStream, dataOutputStream);
                        break;
                    case "2":
                        showPolls(scanner, dataInputStream, dataOutputStream);
                        break;
                    case "3":
                        doPoll(scanner, dataInputStream, dataOutputStream);
                        break;
                    case "0":
                        dataOutputStream.writeUTF(Commands.CLOSE);
                        return;
                }
            }
            ///  ----->
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createPoll(Scanner scanner, DataInputStream dataInputStream,
        DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(Commands.CREATE_POLL);

        System.out.println("Введите вопрос...");
        dataOutputStream.writeUTF(scanner.nextLine());

        System.out.println("Введите количество ответов...");
        var count = scanner.nextInt();
        dataOutputStream.writeInt(count);

        scanner.nextLine();

        for (int i = 0; i < count; ++i) {
            System.out.println("Введите ответ " + (i+1) + "...");
            dataOutputStream.writeUTF(scanner.nextLine());
        }

        dataOutputStream.flush();
        // принимаем ответ от сервера
        System.out.println("Сервер ответил: " + dataInputStream.readUTF());
    }

    /**
     * Прочитать и показать список вопросов
     */
    private static void showPolls(Scanner scanner, DataInputStream dataInputStream,
        DataOutputStream dataOutputStream) throws IOException {

        var polls = getPolls(dataInputStream, dataOutputStream);

        if (polls.isEmpty()) {
            System.out.println("Опросов нет");
            return;
        }

        for (var i = 0; i < polls.size(); ++i) {
            var poll = polls.get(i);
            System.out.println("Опрос " + (i+1));
            System.out.println(poll.getPollQuestion());

            int totalVotes = poll.getListOfVotes().stream().reduce(0, Integer::sum);

            for (var j = 0; j < poll.getListOfOptions().size(); ++j) {
                System.out.print("" + (j+1) + ". " + poll.getListOfOptions().get(j));
                if (totalVotes > 0) {
                    var percent = (int)(poll.getListOfVotes().get(j) * 1.0 / totalVotes * 100);
                    System.out.print(" Результат: " + percent);
                }
                System.out.println();
            }
        }
    }

    /**
     * Читает все опросы из сервера
     */
    private static List<PollDto> getPolls(DataInputStream dataInputStream,
        DataOutputStream dataOutputStream) throws IOException {

        dataOutputStream.writeUTF(Commands.SHOW_POLLS);
        dataOutputStream.flush();

        var pollsCount = dataInputStream.readInt();
        var polls = new ArrayList<PollDto>(pollsCount);

        for (var i = 0; i < pollsCount; ++i) {
            var id = dataInputStream.readInt();
            var question = dataInputStream.readUTF();

            var answerCount = dataInputStream.readInt();
            var answers = new ArrayList<String>();
            for (var j = 0; j < answerCount; ++j) {
                answers.add(dataInputStream.readUTF());
            }

            var votes = new ArrayList<Integer>();
            for (var j = 0; j < answerCount; ++j) {
                votes.add(dataInputStream.readInt());
            }

            polls.add(new PollDto(id, question, answers, votes));
        }

        return polls;
    }

    private static void doPoll(Scanner scanner, DataInputStream dataInputStream,
        DataOutputStream dataOutputStream) throws IOException {

        var polls = getPolls(dataInputStream, dataOutputStream);

        if (polls.isEmpty()) {
            System.out.println("Опросов нет");
            return;
        }

        System.out.println("Выберите опрос:");
        for (var poll: polls) {
            System.out.println("" + poll.getId() + ": " + poll.getPollQuestion());
        }
        var id = scanner.nextInt();
        scanner.nextLine();

        var poll = polls.stream()
            .filter(p -> p.getId() == id)
            .findFirst().orElse(null);
        if (poll == null) {
            System.out.println("Неверный ID");
            return;
        }

        System.out.println(poll.getPollQuestion());
        System.out.println("Выберите ответ:");
        for (var j = 0; j < poll.getListOfOptions().size(); ++j) {
            System.out.println("" + (j+1) + ": " + poll.getListOfOptions().get(j));
        }
        var answerNo = scanner.nextInt() - 1;
        scanner.nextLine();
        if (answerNo < 0 || answerNo >= poll.getListOfOptions().size()) {
            System.out.println("Неверный номер ответа");
            return;
        }

        dataOutputStream.writeUTF(Commands.DO_POLL);
        dataOutputStream.writeInt(poll.getId());
        dataOutputStream.writeInt(answerNo);
        dataOutputStream.flush();

        // принимаем ответ от сервера
        System.out.println("Сервер ответил: " + dataInputStream.readUTF());
    }
}


