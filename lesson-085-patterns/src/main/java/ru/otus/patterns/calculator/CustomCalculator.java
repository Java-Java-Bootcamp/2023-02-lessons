package ru.otus.patterns.calculator;

import ru.otus.patterns.PowerData;

public class CustomCalculator implements Calculator {

    @Override
    public int calculate(PowerData inputData) {
        System.out.println("Самодельный калькулятор:");
        int result = 1;
        for (int i=1; i<=inputData.getPower(); i++) {
            result *= inputData.getNumber();
        }
        System.out.println("Результат: " + result);
        return result;
    }


}
