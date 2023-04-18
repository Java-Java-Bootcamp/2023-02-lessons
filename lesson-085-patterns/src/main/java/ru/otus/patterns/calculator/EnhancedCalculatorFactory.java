package ru.otus.patterns.calculator;

public class EnhancedCalculatorFactory implements CalculatorFactory {

    @Override
    public Calculator createCalculator() {
        return new EnhancedCalculatorAdapter();
    }
}
