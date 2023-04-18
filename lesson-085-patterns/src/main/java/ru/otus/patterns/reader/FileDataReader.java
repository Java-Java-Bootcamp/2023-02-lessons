package ru.otus.patterns.reader;

import ru.otus.patterns.PowerData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDataReader implements DataReader {

    @Override
    public PowerData readData() {
        try {
            Scanner scanner = new Scanner(new File("/Users/annaalkh/Downloads/2023-02-lessons/lesson-085-patterns/src/main/resources/numbers.txt"));
            int number = scanner.nextInt();
            int power = scanner.nextInt();
            return new PowerData(number, power);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
