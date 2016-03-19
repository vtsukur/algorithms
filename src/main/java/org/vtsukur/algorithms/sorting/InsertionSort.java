package org.vtsukur.algorithms.sorting;

import org.vtsukur.algorithms.util.ArrayUtils;
import org.vtsukur.algorithms.util.ComparableUtils;

/**
 * @author volodymyr.tsukur
 */
public final class InsertionSort extends BaseSort {

    @Override
    public <T extends Comparable<T>> void sort(final T[] array) {
        sort(array, 0, array.length - 1, 1);
    }

    public <T extends Comparable<T>> void sort(final T[] array, final int from, final int to) {
        sort(array, from, to, 1);
    }

    <T extends Comparable<T>> void sort(final T[] array, final int from, final int to, final int h) {
        final int start = from + h;
        for (int i = start; i <= to; ++i) {
            int j = i;
            while (j >= start && ComparableUtils.less(array[j], array[j - h])) {
                ArrayUtils.swap(array, j, j - h);
                j -= h;
            }
        }
    }

}
