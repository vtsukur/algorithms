package org.vtsukur.algorithms.queue;

import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public final class CustomLinkedListBasedQueueOfStrings implements QueueOfStrings {

    private Node head;

    private Node tail;

    private int size = 0;

    @Override
    public void enqueue(final String item) {
        final Node oldTail = tail;
        tail = new Node(item, null);
        if (oldTail != null) {
            oldTail.next = tail;
        } else {
            head = tail;
        }
        size++;
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't dequeue from empty queue");
        }

        final Node oldHead = head;
        String value = oldHead.value;
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
    public String toString() {
        return "based on custom implementation of linked list";
    }

    /**
     * @author volodymyr.tsukur
     */
    private static final class Node { // 32 bytes overhead for each entry

        // 16 bytes object overhead

        String value; // 8 bytes pointer overhead

        Node next; // 8 bytes pointer overhead

        public Node(final String value, final Node next) {
            this.value = value;
            this.next = next;
        }

    }

}
