package org.vtsukur.algorithms.queue;

import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class ArrayBasedQueue implements Queue {

    private int head;

    private int tail;

    private int size;

    private String[] array = new String[1];

    @Override
    public void enqueue(final String item) {
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
    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't dequeue from empty queue");
        }

        if (size == array.length / 4) {
            resize(array.length / 2);
        }

        final String item = array[head];
        array[head] = null;
        head++;
        size--;

        return item;
    }

    private void resize(final int capacity) {
        final String[] oldArray = array;
        array = new String[capacity];
        System.arraycopy(oldArray, head, array, 0, size);
        head = 0;
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

}
