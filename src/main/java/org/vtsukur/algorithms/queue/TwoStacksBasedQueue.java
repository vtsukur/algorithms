package org.vtsukur.algorithms.queue;

import org.vtsukur.algorithms.stack.ArrayBasedStack;
import org.vtsukur.algorithms.stack.Stack;

import java.util.Iterator;

/**
 * @author volodymyr.tsukur
 */
public final class TwoStacksBasedQueue<T> implements Queue<T> {

    private final Stack<T> first = new ArrayBasedStack<>();

    private final Stack<T> second = new ArrayBasedStack<>();

    @Override
    public void enqueue(final T item) {
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        second.push(item);
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
    }

    @Override
    public T dequeue() {
        return second.pop();
    }

    @Override
    public boolean isEmpty() {
        return second.isEmpty();
    }

    @Override
    public int size() {
        return second.size();
    }

    @Override
    public Iterator<T> iterator() {
        return second.iterator();
    }

}
