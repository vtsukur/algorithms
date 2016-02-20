package org.vtsukur.algorithms.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class LinkedListBasedQueue<T> implements Queue<T> {

    private final LinkedList<T> list = new LinkedList<>();

    @Override
    public void enqueue(final T item) {
        list.addLast(item);
    }

    @Override
    public T dequeue() {
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
    public Iterator<T> iterator() {
        return list.iterator();
    }

}
