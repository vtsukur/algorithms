package org.vtsukur.algorithms.stack;

/**
 * @author volodymyr.tsukur
 */
public final class CustomLinkedListBasedStackOfStrings implements StackOfStrings {

    private Node head;

    private int size = 0;

    @Override
    public void push(final String item) {
        final Node oldHead = head;
        head = new Node(item, oldHead);
        size++;
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Can't pop from empty stack");
        }

        final Node oldHead = head;
        String value = oldHead.value;
        head = oldHead.next;
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

    /**
     * @author volodymyr.tsukur
     */
    private static final class Node {

        String value;

        Node next;

        public Node(final String value, final Node next) {
            this.value = value;
            this.next = next;
        }

    }

}
