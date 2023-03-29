package org.example;

import org.example.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManger {
    private List<Task> tasks = new ArrayList<>();

    public List<Task> get() {
        return tasks;
    }

    public void add(Task task) {
        // todo: check time period
        tasks.add(task);
    }

    public List<Task> findByCityName(String name) {
        return tasks.stream()
                .filter(task -> task.getCity() != null)
                .filter(task -> task.getCity().getName().equals(name))
                .collect(Collectors.toList());
    }

    public void delete(Task task) {
        tasks.remove(task);
    }
}
