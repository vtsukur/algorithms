package org.vtsukur.algorithms.sorting;

/**
 * @author volodymyr.tsukur
 */
public final class InsertionSort extends BaseSort {

    @Override
    public <T extends Comparable<T>> void sort(final T[] array) {
        sort(array, 1);
    }

    <T extends Comparable<T>> void sort(final T[] array, final int h) {
        for (int i = h; i < array.length; ++i) {
            int j = i;
            while (j >= h && SortUtils.less(array[j], array[j - h])) {
                SortUtils.swap(array, j, j - h);
                j -= h;
            }
        }
    }

}
