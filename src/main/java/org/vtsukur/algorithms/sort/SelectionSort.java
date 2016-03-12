package org.vtsukur.algorithms.sort;

import static org.vtsukur.algorithms.sort.SortUtils.less;
import static org.vtsukur.algorithms.sort.SortUtils.swap;

/**
 * @author volodymyr.tsukur
 */
public final class SelectionSort<T extends Comparable<T>> extends BaseSort<T> {

    public void sort(final T[] array) {
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
