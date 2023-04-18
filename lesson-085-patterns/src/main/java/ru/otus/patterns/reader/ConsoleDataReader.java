package ru.otus.patterns.reader;

import ru.otus.patterns.PowerData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsoleDataReader implements DataReader {

    @Override
    public PowerData readData() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int power = scanner.nextInt();
        return new PowerData(number, power);
    }
}
