package org.vtsukur.algorithms.stack;

/**
 * @author volodymyr.tsukur
 */
public interface Stack<T> extends Iterable<T> {

    void push(T item);

    T pop();

    boolean isEmpty();

    int size();

}
