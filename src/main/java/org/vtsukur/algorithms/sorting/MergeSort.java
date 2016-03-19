package org.vtsukur.algorithms.sorting;

import java.lang.reflect.Array;

import static org.vtsukur.algorithms.util.ComparableUtils.less;
import static org.vtsukur.algorithms.util.ComparableUtils.lessOrEqualTo;

/**
 * @author volodymyr.tsukur
 */
public final class MergeSort extends BaseSort {

    @Override
    public <T extends Comparable<T>> void sort(final T[] array) {
        new Worker<>(array).sort();
    }

    /**
     * @author volodymyr.tsukur
     */
    private static class Worker<T extends Comparable<T>> {

        final T[] array;

        final T[] aux;

        final InsertionSort insertionSort = new InsertionSort();

        Worker(final T[] array) {
            this.array = array;
            //noinspection unchecked
            aux = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
        }

        void sort() {
            doSort(0, array.length - 1);
        }

        void doSort(final int from, final int to) {
            final int size = to - from + 1;
            if (size <= 1) {
                return;
            }

            if (size <= 7) {
                insertionSort.sort(array, from, to);
                return;
            }

            final int middle = from + size / 2;
            doSort(from, middle - 1);
            doSort(middle, to);
            if (lessOrEqualTo(array[middle - 1], array[middle])) {
                return;
            }
            merge(from, middle, to, size);
        }

        void merge(final int from, final int middle, final int to, final int size) {
            System.arraycopy(array, from, aux, from, size);

            final int toExclusive = to + 1;
            int m = from, i = m, j = middle;
            while (i < middle && j < toExclusive) {
                if (less(aux[i], aux[j])) {
                    array[m++] = aux[i++];
                } else {
                    array[m++] = aux[j++];
                }
            }
            while (i < middle) {
                array[m++] = aux[i++];
            }
            while (j < toExclusive) {
                array[m++] = aux[j++];
            }
        }

    }

}
