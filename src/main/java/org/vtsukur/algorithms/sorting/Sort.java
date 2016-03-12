package org.vtsukur.algorithms.sorting;

/**
 * @author volodymyr.tsukur
 */
@FunctionalInterface
public interface Sort<T extends Comparable<T>> {

    void sort(T[] array);

}
