package ru.otus.gc;

/*
-Xms256m
-Xmx256m
*/

import java.util.ArrayList;

public class OOMDemo {

    public static void main(String[] args) {
        var list = new ArrayList<Integer>();

        while (true) {
            list.add(42);
        }
    }
}
