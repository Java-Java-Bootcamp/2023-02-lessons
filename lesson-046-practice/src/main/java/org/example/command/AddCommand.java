package org.example.command;

import org.example.model.Task;
import org.example.converter.TaskConverter;
import org.example.TaskManger;

import java.util.Scanner;

public class AddCommand implements Command {
    private static final String NAME = "Add task";

    public AddCommand(TaskManger manger) {
        this.manger = manger;
    }

    private TaskManger manger;
    @Override
    public Object execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date-time in format 'yyyy-MM-dd HH:mm'");
        String dateTime = scanner.nextLine();
        System.out.println("Enter duration");
        long duration = scanner.nextLong();
        System.out.println("Enter description");
        String description = scanner.nextLine();
        System.out.println("Enter manager name");
        String managerName = scanner.nextLine();
        System.out.println("Enter city");
        String city = scanner.nextLine();

        Task task = TaskConverter.convert(description, dateTime, duration, city);
        manger.add(task);
        return null;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
