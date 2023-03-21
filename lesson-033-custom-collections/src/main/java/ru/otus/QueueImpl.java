package ru.otus;

public class QueueImpl implements Queue {
    // container: массив, список, связный список

    private Container head = null; // начало очереди
    private Container tail = null; // конец очереди

    @Override
    public boolean add(Object elem) {
        Container prevTail = tail;
        tail = new Container(elem);
        tail.nextContainer = prevTail;
        if (prevTail == null) {
            head = tail;
        } else {
            prevTail.prevContainer = tail;
        }

        return true;
    }

    @Override
    public Object poll() {
        if (head == null) {
            throw new RuntimeException("Queue is empty");
        }

        Container prevHead = head;
        head = prevHead.prevContainer;

        if (head == null) {
            tail = null;
        }

        head.nextContainer = null;

        return prevHead;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private static class Container {
        //tail: [ x ] -> [ y ] -> [ z ] -> null: head
        private final Object value; // здесь само хранимое значение
        private Container nextContainer; // ссылка на следующий элемент

        private Container prevContainer; // ссылка на предыдущий элемент

        private Container(Object value) {
            this.value = value;
        }

        public void setNextContainer(Container nextContainer) {
            this.nextContainer = nextContainer;
        }
    }

    private class LinkedIterator implements Iterator {
        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public Object next() {
            return poll();
        }
    }
}
