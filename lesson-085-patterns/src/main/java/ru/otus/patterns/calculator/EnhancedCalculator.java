package ru.otus.patterns.calculator;

//библиотечный класс
public class EnhancedCalculator {

    CalculationResult calculateSuper(int number, int power) {
        double result = Math.pow(number, power);
        return new CalculationResult(result, 0);
    }

    static class CalculationResult {
        double result;
        double precision;

        public CalculationResult(double result, double precision) {
            this.result = result;
            this.precision = precision;
        }
    }
}


