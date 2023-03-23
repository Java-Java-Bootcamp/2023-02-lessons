package ru.otus;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("A name", "A surname"),
                new Employee("B name", "B surname"),
                new Employee("C name", "C surname"),
                new Employee("D name", "D surname"),
                new Employee("E name", "E surname")
                );

        employees.stream().toList();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
