package org.vtsukur.algorithms.stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class LinkedListBasedStackOfStrings implements StackOfStrings {

    private final LinkedList<String> list = new LinkedList<>();

    @Override
    public void push(final String item) {
        list.addFirst(item);
    }

    @Override
    public String pop() {
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
    public String toString() {
        return "based on linked list";
    }

}
