package org.vtsukur.algorithms.sorting;

import java.util.Random;

import static org.vtsukur.algorithms.util.ArrayUtils.swap;
import static org.vtsukur.algorithms.util.ComparableUtils.less;

/**
 * @author volodymyr.tsukur
 */
public final class QuickSortBidirectionalPartition extends BaseSort {

    private static final Random RANDOM = new Random();

    @Override
    public <T extends Comparable<T>> void sort(final T[] array) {
        doSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void doSort(final T[] array, final int from, final int to) {
        if (from >= to) {
            return;
        }

        final int pivotIndex = from + RANDOM.nextInt(to - from + 1);
        swap(array, from, pivotIndex);
        final T pivot = array[from];

        int i = from + 1;
        int j = to;

        do {
            while (i <= to && less(array[i], pivot)) {
                ++i;
            }
            while (j >= from && less(pivot, array[j])) {
                --j;
            }

            if (i < j) {
                swap(array, i, j);
                ++i;
                --j;
            }
        } while (i <= j);
        swap(array, from, j);

        doSort(array, from, j);
        doSort(array, i, to);
    }

}
