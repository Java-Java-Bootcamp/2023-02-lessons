package org.example.command;

import org.example.model.Task;
import org.example.TaskManger;

import java.util.List;

public class GetCommand implements Command {
    private static final String NAME = "Get task";
    private TaskManger manger;

    public GetCommand(TaskManger manger) {
        this.manger = manger;
    }

    @Override
    public Object execute() {
        List<Task> tasks = manger.get();
        System.out.println(tasks);
        return null;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
