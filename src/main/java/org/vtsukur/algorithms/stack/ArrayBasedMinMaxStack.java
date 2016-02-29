package org.vtsukur.algorithms.stack;

import java.util.Iterator;

/**
 * @author volodymyr.tsukur
 */
public final class ArrayBasedMinMaxStack<T extends Comparable<T>> implements MinMaxStack<T> {

    private final ArrayBasedStack<T> stack = new ArrayBasedStack<>();

    private final ArrayBasedStack<T> minStack = new ArrayBasedStack<>();

    private final ArrayBasedStack<T> maxStack = new ArrayBasedStack<>();

    @Override
    public void push(final T item) {
        stack.push(item);

        pushMin(item);
        pushMax(item);
    }

    private void pushMax(final T item) {
        if (!maxStack.isEmpty()) {
            final T max = maxStack.peek();
            maxStack.push(item.compareTo(max) > 0 ? item : max);
        } else {
            maxStack.push(item);
        }
    }

    private void pushMin(final T item) {
        if (!minStack.isEmpty()) {
            final T min = minStack.peek();
            minStack.push(item.compareTo(min) < 0 ? item : min);
        } else {
            minStack.push(item);
        }
    }

    @Override
    public T pop() {
        final T item = stack.pop();

        minStack.pop();
        maxStack.pop();

        return item;
    }

    @Override
    public T peek() {
        return stack.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }

    @Override
    public T min() {
        return minStack.peek();
    }

    @Override
    public T max() {
        return maxStack.peek();
    }

}
