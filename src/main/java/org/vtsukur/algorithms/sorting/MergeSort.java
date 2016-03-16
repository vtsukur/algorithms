package org.vtsukur.algorithms.sorting;

import org.vtsukur.algorithms.util.ComparableUtils;

import java.util.Arrays;

/**
 * @author volodymyr.tsukur
 */
public final class MergeSort extends BaseSort {

    @Override
    public <T extends Comparable<T>> void sort(final T[] array) {
        doSort(array, 0, array.length - 1);
    }

    private <T extends Comparable<T>> void doSort(final T[] array, final int from, final int to) {
        final int size = to - from + 1;
        if (size <= 1) {
            return;
        }

        final int middle = from + size / 2;
        doSort(array, from, middle - 1);
        doSort(array, middle, to);
        merge(array, from, middle, to, size);
    }

    private <T extends Comparable<T>> void merge(final T[] array, final int from, final int middle, final int to,
            final int size) {
        final int part1Size = middle - from;

        final T[] cpy = Arrays.copyOfRange(array, from, to + 1);
        int m = from;
        int i = 0, j = part1Size;
        while (i < part1Size && j < size) {
            if (ComparableUtils.less(cpy[i], cpy[j])) {
                array[m++] = cpy[i++];
            } else {
                array[m++] = cpy[j++];
            }
        }
        while (i < part1Size) {
            array[m++] = cpy[i++];
        }
        while (j < size) {
            array[m++] = cpy[j++];
        }
    }

}
