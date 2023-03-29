package org.example;

import org.example.command.AddCommand;
import org.example.command.Command;
import org.example.command.FindByCityCommand;
import org.example.command.GetCommand;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static TaskManger TASK_MANGER = new TaskManger();
    private final static List<Command> COMMANDS = Arrays.asList(
            new AddCommand(TASK_MANGER),
            new GetCommand(TASK_MANGER),
            new FindByCityCommand(TASK_MANGER));

    public static void main(String[] args) {
        String command = "";
        Scanner scanner = new Scanner(System.in);
        while(!"EXIT".equals(command)) {
            showCommands();
            String commandName = scanner.nextLine();
            runCommand(commandName);
        }
    }

    private static void runCommand(String commandName) {
        for (Command command : COMMANDS) {
            if(commandName.equals(command.getName())) {
                command.execute();
            }
        }
    }

    private static void showCommands() {
        for (Command command : COMMANDS) {
            System.out.println(command.getName());
        }
    }
}
