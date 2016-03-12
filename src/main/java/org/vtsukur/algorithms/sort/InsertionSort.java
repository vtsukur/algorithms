package org.vtsukur.algorithms.sort;

/**
 * @author volodymyr.tsukur
 */
public final class InsertionSort<T extends Comparable<T>> extends BaseSort<T> {

    @Override
    public void sort(final T[] array) {
        for (int i = 1; i < array.length; ++i) {
            int j = i;
            while (j > 0 && SortUtils.less(array[j], array[j - 1])) {
                SortUtils.swap(array, j, j - 1);
                --j;
            }
        }
    }

}
