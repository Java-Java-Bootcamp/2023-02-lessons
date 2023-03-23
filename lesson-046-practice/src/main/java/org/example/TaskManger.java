package org.example;

import org.example.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskManger {
    private List<Task> tasks = new ArrayList<>();

    List<Task> get() {
        return tasks;
    }

    void add(Task task) {
        // todo: check time period
        tasks.add(task);
    }

    void delete(Task task) {
        tasks.remove(task);
    }
}
