package ru.otus;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        /*List<Employee> employees = createEmployees("None");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        taskOne(employees);*/

        List<Department> departments = createDepartments();
        System.out.println(departments);

       /* Set<Employee> employees = departments.get(0).getEmployees();
        System.out.println(departments.get(0).getEmployees());
        employees.add(new Employee("Spy name", "Spy surname", 99));
        System.out.println(departments.get(0).getEmployees());*/
    }

    private static List<Department> createDepartments() {
        Random random = new Random();

        Department a = new Department("Dep A",
                new Employee("Head of A Name",
                        "Head of A Surname", random.nextInt(18, 120)),
                new HashSet<>(createEmployees("Dep A"))
        );

        Department b = new Department("Dep B",
                new Employee("Head of B Name",
                        "Head of B Surname", random.nextInt(18, 120)),
                new HashSet<>(createEmployees("Dep B")));

        Department c = new Department("Dep B",
                new Employee("Head of C Name",
                        "Head of C Surname", random.nextInt(18, 120)),
                new HashSet<>(createEmployees("Dep C")));

        return List.of(a, b, c);
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

    private static List<Employee> createEmployees(String depName) {
        Random random = new Random();
        List<Employee> employees = List.of(
                new Employee("A" + depName + "name", "A surname", random.nextInt(18, 35)),
                new Employee("B" + depName + "name", "B surname", random.nextInt(18, 50)),
                new Employee("C" + depName + "name", "C surname", random.nextInt(18, 40)),
                new Employee("D" + depName + "name", "D surname", random.nextInt(18, 60)),
                new Employee("E" + depName + "name", "E surname", random.nextInt(18, 120))
        );
        return employees;
    }
}
