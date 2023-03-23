package ru.otus;

import java.util.Set;

import static java.util.Collections.emptySet;

/**
 * Департамент:
 * название;
 * руководитель;
 * сотрудники;
 */
public class Department {
    private String name;
    private Employee head;

    private Set<Employee> employees;

    public Department(
            String name,
            Employee head,
            Set<Employee> employees
    ) {
        if (name == null || head == null) {
            throw new IllegalArgumentException("Department should have name and head");
        }
        this.name = name;
        this.head = head;
        this.employees = employees == null ? emptySet() : employees;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Employee getHead() {
        return head;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + ", head: " + head.getName() + ", size: " + employees.size();
    }
}
