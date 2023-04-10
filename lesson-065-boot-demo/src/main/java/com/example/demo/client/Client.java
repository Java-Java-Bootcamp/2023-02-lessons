package com.example.demo.client;

public class Client {
    private long id;

    private String name;

    private String secondName;

    private int age;

    public Client() {
    }

    public Client(long id, String name, String secondName, int age) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
