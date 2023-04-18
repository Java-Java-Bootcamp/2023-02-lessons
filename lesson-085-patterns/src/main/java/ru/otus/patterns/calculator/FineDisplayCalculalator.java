package ru.otus.patterns.calculator;

import ru.otus.patterns.PowerData;

//декоратор
public class FineDisplayCalculalator implements Calculator {

    final Calculator decorated;

    public FineDisplayCalculalator(Calculator decorated) {
        this.decorated = decorated;
    }

    @Override
    public int calculate(PowerData inputData) {
        int result = decorated.calculate(inputData);
        System.out.println("***********");
        System.out.println("***" + result + "***");
        System.out.println("***********");
        return result;
    }
}
