package org.vtsukur.algorithms.queue;

/**
 * @author volodymyr.tsukur
 */
public interface Queue {

    void enqueue(String item);

    String dequeue();

    boolean isEmpty();

    int size();

}
