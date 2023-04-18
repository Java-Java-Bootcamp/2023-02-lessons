package ru.otus.patterns.calculator;

public class StandardCalculatorFactory implements CalculatorFactory {

    @Override
    public Calculator createCalculator() {
        return new StandardPowerCalculator();
    }
}
