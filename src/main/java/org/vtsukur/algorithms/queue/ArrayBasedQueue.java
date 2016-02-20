package org.vtsukur.algorithms.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class ArrayBasedQueue<T> implements Queue<T> {

    private int head;

    private int tail;

    private int size;

    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[1];

    @Override
    public void enqueue(final T item) {
        if (tail == array.length) {
            if (head == 0) {
                resize(tail * 2);
            } else {
                pack();
            }
        }

        array[tail] = item;
        tail++;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't dequeue from empty queue");
        }

        if (size == array.length / 4) {
            resize(array.length / 2);
        }

        final T item = array[head];
        array[head] = null;
        head++;
        size--;

        return item;
    }

    @SuppressWarnings("unchecked")
    private void resize(final int capacity) {
        final T[] oldArray = array;
        array = (T[]) new Object[capacity];
        System.arraycopy(oldArray, head, array, 0, size);
        head = 0;
        tail = size;
    }

    private void pack() {
        int i = head;
        while (i < tail) {
            array[i - head] = array[i];
            array[i] = null;
            ++i;
        }

        tail -= head;
        head = 0;
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

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    /**
     * @author volodymyr.tsukur
     */
    private final class QueueIterator implements Iterator<T> {

        private int i = head;

        @Override
        public boolean hasNext() {
            return i < tail;
        }

        @Override
        public T next() {
            final T el = array[i];
            i++;
            return el;
        }

    }

}
