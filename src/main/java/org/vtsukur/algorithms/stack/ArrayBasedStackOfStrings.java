package org.vtsukur.algorithms.stack;

import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class ArrayBasedStackOfStrings implements StackOfStrings {

    private int size;

    private String[] array = new String[1];

    @Override
    public void push(final String item) {
        if (size == array.length) { // resize
            final String[] oldArray = array;
            array = new String[size * 2];
            System.arraycopy(oldArray, 0, array, 0, size);
        }

        array[size] = item;
        size++;
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't pop from empty stack");
        }

        --size;
        final String item = array[size];
        array[size] = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

}
