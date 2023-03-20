package org.example;

public interface List {
    void add(Object o);

    void add(int index, Object o);

    Object get(int i);

    void remove(Object o);

    void remove(int index);

    int size();
}
