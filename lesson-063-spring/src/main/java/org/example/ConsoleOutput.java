package org.example;

public class ConsoleOutput implements UserOutput {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
