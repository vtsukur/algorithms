package org.vtsukur.algorithms.priority_queue;

/**
 * @author volodymyr.tsukur
 */
public interface MaxPriorityQueue<K extends Comparable<K>> {

    void add(K key);

    K pollMax();

    K peekMax();

    boolean isEmpty();

    int size();

    void clear();

}
