package org.example.command;

import org.example.TaskManger;
import org.example.command.Command;
import org.example.model.Task;

import java.util.List;
import java.util.Scanner;

public class FindByCityCommand implements Command {

    private final TaskManger manager;

    public FindByCityCommand(TaskManger manager) {
        this.manager = manager;
    }

    @Override
    public Object execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter city name");
        String name = scanner.nextLine();
        List<Task> byCityName = manager.findByCityName(name);
        System.out.println(byCityName);
        return null;
    }

    @Override
    public String getName() {
        return "find by city";
    }
}
