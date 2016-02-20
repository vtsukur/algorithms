package org.vtsukur.algorithms.stack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class LinkedListBasedStack<T> implements Stack<T> {

    private final LinkedList<T> list = new LinkedList<>();

    @Override
    public void push(final T item) {
        list.addFirst(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't pop from empty stack");
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
