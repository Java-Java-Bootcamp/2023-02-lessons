package ru.otus;

public class SetOnList implements Set {
    private final List container = new ArrayList();

    @Override
    public boolean add(Object elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Set can not contain null elements");
        }

        if (container.contains(elem)) {
            return false;
        }

        return container.add(elem);
    }

    @Override
    public boolean contains(Object elem) {
        return container.contains(elem);
    }

    @Override
    public boolean remove(Object elem) {
        return container.remove(elem);
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
