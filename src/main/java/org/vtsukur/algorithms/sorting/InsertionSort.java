package org.vtsukur.algorithms.sorting;

/**
 * @author volodymyr.tsukur
 */
public final class InsertionSort<T extends Comparable<T>> extends BaseSort<T> {

    @Override
    public void sort(final T[] array) {
        sort(array, 1);
    }

    void sort(final T[] array, final int h) {
        for (int i = h; i < array.length; ++i) {
            int j = i;
            while (j >= h && SortUtils.less(array[j], array[j - h])) {
                SortUtils.swap(array, j, j - h);
                j -= h;
            }
        }
    }

}
