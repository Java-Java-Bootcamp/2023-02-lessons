package org.example.model;

import org.example.ActionEventListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Action {
    private LocalDateTime dateTime;

    private long duration;

    private Person manager;

    private List<Person> participants = new ArrayList<>();

    private City city;

    private List<ActionEventListener> events;

    public Action() {
    }

    public Action(LocalDateTime dateTime, long duration, Person manager, List<Person> participants, City city) {
        this.dateTime = dateTime;
        this.duration = duration;
        this.manager = manager;
        this.participants = participants;
        this.city = city;
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
}
