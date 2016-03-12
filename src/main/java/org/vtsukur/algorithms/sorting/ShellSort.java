package org.vtsukur.algorithms.sorting;

/**
 * @author volodymyr.tsukur
 */
public final class ShellSort<T extends Comparable<T>> extends BaseSort<T> {

    private final InsertionSort<T> insertionSort = new InsertionSort<>();

    @Override
    public void sort(final T[] array) {
        int h = initialHFactorByKnuth(array.length);
        while (h > 0) {
            insertionSort.sort(array, h);
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
