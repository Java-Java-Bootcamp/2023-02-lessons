package org.example;

import java.util.Objects;

public class ArrayList implements List {
    private Object[] items;
    private int currentCount;

    public ArrayList() {
        items = new Object[currentCount];
    }

    public void add(Object o) {
        if(items.length - currentCount == 0) {
            resizeArray();
        }
        items[currentCount++] = o;
    }

    public void add(int index, Object o) {
        if(items.length - currentCount == 0) {
            resizeArray();
        }
        if (index >= currentCount) {
            items[index] = o;
            currentCount = index;
        } else {
            for (int i = index; i <= currentCount - 1; i++) {
                items[i+1] = items[i];
            }
            items[index] = o;
            currentCount++;
        }
    }

    private void resizeArray() {
        Object[] temp = new Object[items.length == 0 ? 1 : items.length * 2];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public Object get(int i) {
        return items[i];
    }

    public Object get(Object o) {
        int index = -1;
        for (int i = 0; i <= currentCount - 1; i++) {
            if(Objects.equals(items[i], o)) {
                index = i;
                break;
            }
        }
        return items[index];
    }

    public void remove(Object o) {
        int index = -1;
        for (int i = 0; i < items.length; i++) {
            if(o.equals(items[i])) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return;
        }
        // items[i] was removed
        for (int i = index+1; i <= currentCount - 1; i++) {
            items[i-1] = items[i];
        }
        currentCount--;
    }

    public void remove(int index) {
        // items[i] was removed
        for (int i = index+1; i <= currentCount - 1; i++) {
            items[i-1] = items[i];
        }
        currentCount--;
    }

    public int size() {
        return currentCount;
    }
}
