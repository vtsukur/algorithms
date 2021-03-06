package org.vtsukur.algorithms.sorting;

import static org.vtsukur.algorithms.util.ComparableUtils.less;
import static org.vtsukur.algorithms.util.ArrayUtils.swap;

/**
 * @author volodymyr.tsukur
 */
public final class SelectionSort extends BaseSort {

    public <T extends Comparable<T>> void sort(final T[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (less(array[j], array[min])) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

}
