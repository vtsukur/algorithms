package org.vtsukur.algorithms.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class CustomLinkedListBasedStack<T> implements Stack<T> {

    private Node<T> head;

    private int size = 0;

    @Override
    public void push(final T item) {
        final Node<T> oldHead = head;
        head = new Node<>(item, oldHead);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't pop from empty stack");
        }

        final Node<T> oldHead = head;
        T value = oldHead.value;
        head = oldHead.next;
        oldHead.value = null; // GC
        oldHead.next = null; // GC
        size--;

        return value;
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
        return "based on custom implementation of linked list";
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator<>(head);
    }

    /**
     * @author volodymyr.tsukur
     */
    private static final class Node<T> { // 32 bytes overhead for each entry

        // 16 bytes object overhead

        T value; // 8 bytes pointer overhead

        Node<T> next; // 8 bytes pointer overhead

        public Node(final T value, final Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }

    /**
     * @author volodymyr.tsukur
     */
    private static final class StackIterator<T> implements Iterator<T> {

        private Node<T> head;

        public StackIterator(final Node<T> head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public T next() {
            final T value = head.value;
            head = head.next;
            return value;
        }

    }

}
