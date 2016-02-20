package org.vtsukur.algorithms.stack;

/**
 * @author volodymyr.tsukur
 */
public final class StackOfStrings {

    private Node head;

    private int size = 0;

    void push(final String item) {
        head = new Node(item, head);
        size++;
    }

    String pop() {
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

    boolean isEmpty() {
        return size() == 0;
    }

    int size() {
        return size;
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
