package ru.otus;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = createEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        taskOne(employees);

    }

    /*
    - Сформировать список молодых сотрудников (чей возраст менее 30 лет);
    - Найти первого сотрудника, старше 25 лет;
     */
    private static void taskOne(List<Employee> employees) {
        System.out.println("Employees <= 30 years old");
        /*
        employees.stream().forEach(
                employee -> {
                    if (employee.getAge() <= 30) {
                        System.out.println(employee);
                    }
                }
        );
        */

        Predicate<Employee> youngerThanThirtyFilter = employee -> employee.getAge() <= 30;

        List<Employee> youngEmployees = employees.stream()
                .filter(youngerThanThirtyFilter)
                .toList();

        System.out.println(youngEmployees);


        System.out.println("First employee > 25 years old");
        /*List<Employee> employeesOlderThan25 = employees.stream()
                .filter(employee -> employee.getAge() > 25)
                .sorted(
                        (em1, em2) -> em1.getAge() - em2.getAge()
                ).toList();

        System.out.println("First employee > 25 years old: " + employeesOlderThan25.get(0));*/

        Employee firstOlderThan25 = employees.stream()
                .filter(employee -> employee.getAge() > 25)
                .sorted(
                        (em1, em2) -> em1.getAge() - em2.getAge()
                ).findFirst().get();

        System.out.println("First employee > 25 years old: " + firstOlderThan25);

    }

    private static List<Employee> createEmployees() {
        Random random = new Random();
        List<Employee> employees = List.of(
                new Employee("A name", "A surname", random.nextInt(18, 35)),
                new Employee("B name", "B surname", random.nextInt(18, 50)),
                new Employee("C name", "C surname", random.nextInt(18, 40)),
                new Employee("D name", "D surname", random.nextInt(18, 60)),
                new Employee("E name", "E surname", random.nextInt(18, 120))
        );
        return employees;
    }
}
