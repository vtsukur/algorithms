package org.vtsukur.algorithms.queue;

/**
 * @author volodymyr.tsukur
 */
public interface QueueOfStrings {

    void enqueue(String item);

    String dequeue();

    boolean isEmpty();

    int size();

}
