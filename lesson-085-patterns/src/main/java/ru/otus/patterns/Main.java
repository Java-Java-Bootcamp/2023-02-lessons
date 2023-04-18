package ru.otus.patterns;

import ru.otus.patterns.abstractfactory.ConsoleDataProviderFactory;
import ru.otus.patterns.abstractfactory.DataProviderFactory;
import ru.otus.patterns.abstractfactory.FileDataProviderFactory;
import ru.otus.patterns.calculator.*;
import ru.otus.patterns.reader.DataReader;
import ru.otus.patterns.reader.FileDataReader;
import ru.otus.patterns.writer.DataWriter;
import ru.otus.patterns.writer.FileDataWriter;


public class Main {

    public static void main(String[] args) {
        DataProviderFactory factory = new ConsoleDataProviderFactory();

        DataReader reader = factory.createReader();
        PowerData inputData = reader.readData();

        CalculatorFactory calculatorFactory = new EnhancedCalculatorFactory();
        Calculator calculator = calculatorFactory.createCalculator();

        calculator = new FineDisplayCalculalator(calculator);
        int result = calculator.calculate(inputData);

        DataWriter writer = factory.createWriter();
        writer.writeData(result);

    }
}
