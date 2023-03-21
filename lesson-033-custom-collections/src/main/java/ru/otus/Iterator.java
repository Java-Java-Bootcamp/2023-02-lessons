package ru.otus;

public interface Iterator extends java.util.Iterator<Object> {
    boolean hasNext();

    Object next();
}
