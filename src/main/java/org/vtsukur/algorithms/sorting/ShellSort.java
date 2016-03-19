package org.vtsukur.algorithms.sorting;

/**
 * @author volodymyr.tsukur
 */
public final class ShellSort extends BaseSort {

    private final InsertionSort insertionSort = new InsertionSort();

    @Override
    public <T extends Comparable<T>> void sort(final T[] array) {
        int h = initialHFactorByKnuth(array.length);
        while (h > 0) {
            insertionSort.sort(array, 0, array.length - 1, h);
            h = (h - 1) / 3;
        }
    }

    private static int initialHFactorByKnuth(final int max) {
        int h = 1;
        while (h < max) {
            h *= h + 1;
        }
        return h;
    }

}
