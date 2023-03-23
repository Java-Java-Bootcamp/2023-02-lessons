package ru.otus;

/**
 * Сотрудник:
 * имя;
 * фамилия;
 * пол;
 * возраст;
 * профессия;
 * город, в котором работает сотрудник.
 */
public class Employee {
    private String name;
    private String surname;

    private Sex sex;

    private int age;

    private String occupation;

    private String city;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String toString() {
        return name + " " + surname;
    }
}
