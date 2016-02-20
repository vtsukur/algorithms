package org.vtsukur.algorithms.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class LinkedListBasedQueueOfStrings implements QueueOfStrings {

    private final LinkedList<String> list = new LinkedList<>();

    @Override
    public void enqueue(final String item) {
        list.addLast(item);
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't dequeue from empty queue");
        }

        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return "based on linked list";
    }

}
