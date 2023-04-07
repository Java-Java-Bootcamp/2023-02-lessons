package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestElements {

    private final List<TestElement> elements = new ArrayList<>();

    public TestElements(String fileName) throws IOException {
        // читаем вопросы и ответы из файла
        try (var file = new BufferedReader(new FileReader(fileName))) {
            while (true) {
                var testElement = readElement(file);
                if (testElement == null) break;
                elements.add(testElement);
            }
        }
    }

    private TestElement readElement(BufferedReader reader) throws IOException {
        // первая строка - вопрос
        var question = reader.readLine();
        if (question == null) return null; // если конец файла - то все

        // вторая строка - номер верного ответа
        var validAnswerNo = Integer.parseInt(reader.readLine());
        // следующие строки до первой пустой - сами ответы
        var answers = new ArrayList<String>();
        while (true) {
            var answer = reader.readLine();
            if (answer == null || answer.isEmpty())
                break;
            answers.add(answer);
        }
        return new TestElement(question, answers, validAnswerNo);
    }

    public List<TestElement> getElements() {
        return elements;
    }
}
