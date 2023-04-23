package com.example.demo.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class SomeClass {
    private int a;
    private String b;
    private int[] c;
    private Integer[] d;

    public SomeClass(int a, String b, int[] c, Integer[] d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SomeClass obj = new SomeClass(42, "hello world", a, b);

        System.out.println("Class layout");
        System.out.println(ClassLayout.parseClass(SomeClass.class).toPrintable());

        System.out.println("\nClass instance layout");

        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        System.out.println("\nClass instance graph");
        System.out.println(GraphLayout.parseInstance(obj).toFootprint());
    }
}
