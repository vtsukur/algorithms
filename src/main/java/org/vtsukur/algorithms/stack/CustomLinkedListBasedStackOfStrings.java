package org.vtsukur.algorithms.stack;

/**
 * @author volodymyr.tsukur
 */
public final class CustomLinkedListBasedStackOfStrings implements StackOfStrings {

    private Node head;

    private int size = 0;

    @Override
    public void push(final String item) {
        head = new Node(item, head);
        size++;
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Can't pop when stack is empty");
        }

        final Node oldHead = head;
        String value = oldHead.value;
        head = oldHead.previous;
        oldHead.previous = null; // GC
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

    private static final class Node {

        String value;

        Node previous;

        public Node(String value, Node previous) {
            this.value = value;
            this.previous = previous;
        }

    }

}
