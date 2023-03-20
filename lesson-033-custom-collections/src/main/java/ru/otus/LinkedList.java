package ru.otus;

public class LinkedList implements List {
    private final Container HEAD = new Container(null);
    private Container tail = HEAD;

    @Override
    public boolean add(Object elem) {
        tail.nextContainer = new Container(elem);
        tail = tail.nextContainer;
        return true;
    }

    @Override
    public Object get(int idx) {
        int currentIdx = -1;
        Container current = HEAD;

        while (currentIdx < idx) {
            if (current.nextContainer == null) {
                throw new IllegalArgumentException("To big idx");
            }
            currentIdx++;
            current = current.nextContainer;
        }
        return current.value;
    }

    @Override
    public boolean contains(Object elem) {
        return false;
    }

    @Override
    public boolean remove(Object elem) {
        return false;
    }

    private static class Container {
        private final Object value;
        private Container nextContainer;

        private Container(Object value) {
            this.value = value;
        }

        public void setNextContainer(Container nextContainer) {
            this.nextContainer = nextContainer;
        }
    }
}
