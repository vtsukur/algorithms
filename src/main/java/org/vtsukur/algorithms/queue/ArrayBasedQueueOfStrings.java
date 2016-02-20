package org.vtsukur.algorithms.queue;

import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class ArrayBasedQueueOfStrings implements QueueOfStrings {

    private int leftCounter;

    private int rightCounter;

    private int size;

    private String[] array = new String[1];

    @Override
    public void enqueue(final String item) {
        if (rightCounter == array.length) {
            if (leftCounter == 0) {
                resize(rightCounter * 2);
            } else {
                pack();
            }
        }

        array[rightCounter] = item;
        rightCounter++;
        size++;
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't dequeue from empty queue");
        }

        if ((rightCounter - leftCounter) == array.length / 4) {
            pack();
            resize(array.length / 2);
        }

        final String item = array[leftCounter];
        array[leftCounter] = null;
        leftCounter++;
        size--;

        return item;
    }

    private void resize(final int capacity) {
        final String[] oldArray = array;
        array = new String[capacity];
        System.arraycopy(oldArray, 0, array, 0, rightCounter);
    }

    private void pack() {
        int i = leftCounter;
        while (i < rightCounter) {
            array[i - leftCounter] = array[i];
            array[i] = null;
            ++i;
        }

        rightCounter -= leftCounter;
        leftCounter = 0;
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
