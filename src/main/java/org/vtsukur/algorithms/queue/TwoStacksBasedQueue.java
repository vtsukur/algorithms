package org.vtsukur.algorithms.queue;

import org.vtsukur.algorithms.stack.ArrayBasedStack;
import org.vtsukur.algorithms.stack.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class TwoStacksBasedQueue<T> implements Queue<T> {

    private final Stack<T> first = new ArrayBasedStack<>();

    private final Stack<T> second = new ArrayBasedStack<>();

    @Override
    public void enqueue(final T item) {
        first.push(item);
    }

    @Override
    public T dequeue() {
        if (second.isEmpty()) {
            pad();
        }

        return second.pop();
    }

    private void pad() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
    }

    @Override
    public boolean isEmpty() {
        return first.isEmpty() && second.isEmpty();
    }

    @Override
    public int size() {
        return first.size() + second.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    /**
     * @author volodymyr.tsukur
     */
    private final class Itr implements Iterator<T> {

        private Iterator<T> initial = second.iterator();

        private Iterator<T> active = initial;

        @Override
        public boolean hasNext() {
            switchActiveIfInitialIsEmptied();
            return active.hasNext();
        }

        private void switchActiveIfInitialIsEmptied() {
            if (active == initial && !active.hasNext()) {
                pad();
                active = second.iterator();
            }
        }

        @Override
        public T next() {
            switchActiveIfInitialIsEmptied();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return active.next();
        }

    }

}
