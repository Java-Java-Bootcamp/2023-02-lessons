package ru.otus.patterns.calculator;

import ru.otus.patterns.PowerData;

public class EnhancedCalculatorAdapter implements Calculator {

    EnhancedCalculator calculator = new EnhancedCalculator();

    @Override
    public int calculate(PowerData inputData) {
        EnhancedCalculator.CalculationResult result = calculator.calculateSuper(inputData.getNumber(), inputData.getPower());
        return (int) result.result;
    }
}
