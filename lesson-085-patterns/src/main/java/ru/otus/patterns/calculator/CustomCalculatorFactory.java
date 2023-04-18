package ru.otus.patterns.calculator;

public class CustomCalculatorFactory implements CalculatorFactory {

    @Override
    public Calculator createCalculator() {
        return new CustomCalculator();
    }
}
