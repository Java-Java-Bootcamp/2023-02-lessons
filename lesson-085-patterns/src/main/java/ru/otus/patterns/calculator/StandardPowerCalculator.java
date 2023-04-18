package ru.otus.patterns.calculator;

import ru.otus.patterns.PowerData;

public class StandardPowerCalculator implements Calculator {

    @Override
    public int calculate(PowerData powerData) {
        System.out.println("Стандартный калькулятор:");
        double result = Math.pow(powerData.getNumber(), powerData.getPower());
        return (int) result;
    }
}
