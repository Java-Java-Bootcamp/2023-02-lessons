package org.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private List<Action> actionList = new ArrayList<>();

    private LocalDateTime dateTime;

    private long duration;

    private Person manager;

    private List<Person> participants = new ArrayList<>();

    private City city;

    public Task() {
    }

    public Task(LocalDateTime dateTime, long duration, Person manager, List<Person> participants, City city) {
        this.dateTime = dateTime;
        this.duration = duration;
        this.manager = manager;
        this.participants = participants;
        this.city = city;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }

    public List<Person> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Person> participants) {
        this.participants = participants;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Task{" +
                "actionList=" + actionList +
                ", dateTime=" + dateTime +
                ", duration=" + duration +
                ", manager=" + manager +
                ", participants=" + participants +
                ", city=" + city +
                "}\n";
    }
}
