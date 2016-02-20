package org.vtsukur.algorithms.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class CustomLinkedListBasedQueue<T> implements Queue<T> {

    private Node<T> head;

    private Node<T> tail;

    private int size = 0;

    @Override
    public void enqueue(final T item) {
        final Node<T> oldTail = tail;
        tail = new Node<>(item, null);
        if (oldTail != null) {
            oldTail.next = tail;
        } else {
            head = tail;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't dequeue from empty queue");
        }

        final Node<T> oldHead = head;
        T value = oldHead.value;
        head = oldHead.next;
        oldHead.value = null; // GC
        oldHead.next = null; // GC
        size--;

        if (head == null) {
            tail = null;
        }

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
    public Iterator<T> iterator() {
        return new QueueIterator<>(head);
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
    private static final class QueueIterator<T> implements Iterator<T> {

        private Node<T> head;

        public QueueIterator(final Node<T> head) {
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
