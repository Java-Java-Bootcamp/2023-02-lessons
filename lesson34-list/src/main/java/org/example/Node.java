package org.example;

public class Node {
    private Node prev;
    private Node next;
    private Object value;

    public Node() {
    }

    public Node(Node prev, Node next, Object value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
