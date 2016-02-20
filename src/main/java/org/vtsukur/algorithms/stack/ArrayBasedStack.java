package org.vtsukur.algorithms.stack;

import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class ArrayBasedStack implements Stack {

    private int size;

    private String[] array = new String[1];

    @Override
    public void push(final String item) {
        if (size == array.length) {
            resize(size * 2);
        }

        array[size] = item;
        size++;
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't pop from empty stack");
        }

        if (size == array.length / 4) {
            resize(array.length / 2);
        }

        --size;
        final String item = array[size];
        array[size] = null;

        return item;
    }

    private void resize(final int capacity) {
        final String[] oldArray = array;
        array = new String[capacity];
        System.arraycopy(oldArray, 0, array, 0, size);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "based on resizable array";
    }

}
