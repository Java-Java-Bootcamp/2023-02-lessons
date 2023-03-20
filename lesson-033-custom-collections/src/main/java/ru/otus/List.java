package ru.otus;

public interface List extends java.lang.Iterable {
    boolean add(Object elem);

    Object get(int idx);

    boolean contains(Object elem);

    boolean remove(Object elem);
}
