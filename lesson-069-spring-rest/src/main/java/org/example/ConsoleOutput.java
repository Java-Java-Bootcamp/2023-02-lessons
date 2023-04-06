package org.example;

import org.springframework.stereotype.Service;

@Service
public class ConsoleOutput implements UserOutput {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
