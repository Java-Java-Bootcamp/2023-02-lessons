package ru.otus.patterns.writer;

public class ConsoleDataWriter implements DataWriter {

    @Override
    public void writeData(int number) {
        System.out.println("Результат: " + number);
    }
}
