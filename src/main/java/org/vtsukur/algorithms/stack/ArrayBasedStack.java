package org.vtsukur.algorithms.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class ArrayBasedStack<T> implements Stack<T> {

    private int size;

    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[1];

    @Override
    public void push(final T item) {
        if (size == array.length) {
            resize(size * 2);
        }

        array[size] = item;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't pop from empty stack");
        }

        if (size == array.length / 4) {
            resize(array.length / 2);
        }

        --size;
        final T item = array[size];
        array[size] = null;

        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't peek from empty stack");
        }

        return array[size - 1];
    }

    @SuppressWarnings("unchecked")
    private void resize(final int capacity) {
        final T[] oldArray = array;
        array = (T[]) new Object[capacity];
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
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    /**
     * @author volodymyr.tsukur
     */
    private final class StackIterator implements Iterator<T> {

        private int i = size - 1;

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public T next() {
            final T el = array[i];
            i--;
            return el;
        }

    }

}
