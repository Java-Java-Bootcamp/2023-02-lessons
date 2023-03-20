package org.example;

public class LinkedList implements List {
    Node head;
    Node tail;

    int size;

    public LinkedList() {
        head = new Node();
        tail = new Node();
        head.setNext(tail);
        head.setPrev(tail);
        tail.setPrev(head);
        tail.setNext(head);
    }

    @Override
    public void add(Object o) {

    }

    @Override
    public void add(int index, Object o) {

    }

    @Override
    public Object get(int i) {
        return null;
    }

    @Override
    public void remove(Object o) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int size() {
        return 0;
    }
}
