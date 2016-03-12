package org.vtsukur.algorithms.sort;

/**
 * @author volodymyr.tsukur
 */
@FunctionalInterface
public interface Sort<T extends Comparable<T>> {

    void sort(T[] array);

}
