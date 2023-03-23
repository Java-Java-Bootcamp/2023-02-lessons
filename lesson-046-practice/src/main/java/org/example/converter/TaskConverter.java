package org.example.converter;

import org.example.model.City;
import org.example.model.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskConverter {
    public static Task convert(String description, String dateTime, long duration, String city) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return new Task(LocalDateTime.parse(dateTime, formatter), duration, null, null, new City(city));
    }
}
