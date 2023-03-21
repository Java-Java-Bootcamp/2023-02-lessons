package ru.otus;

public interface Queue extends Iterable{
    boolean add(Object elem);

    Object poll(); //work with tail
}
