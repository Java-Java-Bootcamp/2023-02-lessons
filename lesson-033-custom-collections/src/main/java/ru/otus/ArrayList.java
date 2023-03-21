package ru.otus;

public class ArrayList implements List {
    private Object[] container = new Object[10];
    private int lastIdx = 0;

    @Override
    public boolean add(Object elem) {
        if (lastIdx == container.length) {
            Object[] tmp = container;

            container = new Object[container.length * 2];

            for (int i = 0; i < tmp.length; i++) {
                container[i] = tmp[i];
            }
        }
        container[lastIdx++] = elem;
        // container[lastIdx] = elem;
        // lastIdx = lastIdx + 1;
        return true;
    }

    @Override
    public Object get(int idx) {
        if (idx >= container.length) {
            throw new IllegalArgumentException("To big idx");
        }
        return container[idx];
    }

    @Override
    public boolean contains(Object elem) { //Cat
        for (Object o : container) {
            if (elem.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object elem) {
        int foundIdx = -1;
        for (int i = 0; i < container.length; i++) {
            if (elem.equals(container[i])) {
                foundIdx = i;
            }
        }
        if (foundIdx != -1) {
            if (foundIdx == container.length - 1) {
                container[foundIdx] = null;
            }

            for (int i = foundIdx; i < container.length - 1; i++) {
                container[i] = container[i + 1];
                if (container[i + 1] == null) {
                    break;
                }
            }
            return true;
        }

        return false;
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator {
        private int currIdx = 0;

        @Override
        public boolean hasNext() {
            return container[currIdx] != null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new IllegalArgumentException("There is no more elements in a list");
            }
            return container[currIdx++];
        }
    }
}
