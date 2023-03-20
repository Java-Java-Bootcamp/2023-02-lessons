package ru.otus;

public interface List {
    boolean add(Object elem);

    Object get(int idx);

    boolean contains(Object elem);

    boolean remove(Object elem);
}
