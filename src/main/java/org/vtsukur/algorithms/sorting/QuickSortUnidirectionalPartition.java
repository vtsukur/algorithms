package org.vtsukur.algorithms.sorting;

import java.util.Random;

import static org.vtsukur.algorithms.util.ArrayUtils.swap;
import static org.vtsukur.algorithms.util.ComparableUtils.less;
import static org.vtsukur.algorithms.util.ComparableUtils.lessOrEqualTo;

/**
 * @author volodymyr.tsukur
 */
public final class QuickSortUnidirectionalPartition extends BaseSort {

    private static final Random RANDOM = new Random();

    @Override
    public <T extends Comparable<T>> void sort(final T[] array) {
        doSort(array, 0, array.length);
    }

    private static <T extends Comparable<T>> void doSort(final T[] array, final int from, final int to) {
        final int delta = to - from;
        if (delta <= 1) {
            return;
        }

        final int pivotIndex = from + RANDOM.nextInt(delta);
        final T pivot = array[pivotIndex];
        swap(array, from, pivotIndex);

        int hi = from + 1;
        while (hi < to && less(array[hi], pivot)) {
            ++hi;
        }
        int i = hi + 1;
        while (i < to) {
            if (lessOrEqualTo(array[i], pivot)) {
                swap(array, i, hi);
                ++hi;
            }
            ++i;
        }
        swap(array, from, hi - 1);

        doSort(array, from, hi);
        doSort(array, hi, to);
    }

}
