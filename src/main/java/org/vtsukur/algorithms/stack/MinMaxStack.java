package org.vtsukur.algorithms.stack;

/**
 * @author volodymyr.tsukur
 */
public interface MinMaxStack<T extends Comparable<T>> extends Stack<T> {

    T min();

    T max();

}
