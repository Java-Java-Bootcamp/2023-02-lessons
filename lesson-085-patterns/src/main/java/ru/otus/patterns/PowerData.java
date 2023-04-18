package ru.otus.patterns;

public class PowerData {
    private final int number;
    private final int power;

    public PowerData(int number, int power) {
        this.number = number;
        this.power = power;
    }

    public int getNumber() {
        return number;
    }

    public int getPower() {
        return power;
    }
}
