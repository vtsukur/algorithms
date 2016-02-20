package org.vtsukur.algorithms.stack;

/**
 * @author volodymyr.tsukur
 */
public interface Stack {

    void push(String item);

    String pop();

    boolean isEmpty();

    int size();

}
