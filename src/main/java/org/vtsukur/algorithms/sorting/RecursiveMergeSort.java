package org.vtsukur.algorithms.sorting;

import static org.vtsukur.algorithms.util.ComparableUtils.lessOrEqualTo;

/**
 * @author volodymyr.tsukur
 */
public final class RecursiveMergeSort extends BaseSort {

    @Override
    public <T extends Comparable<T>> void sort(final T[] array) {
        new Worker<>(array).sort();
    }

    /**
     * @author volodymyr.tsukur
     */
    private final class Worker<T extends Comparable<T>> extends MergeSortWorker<T> {

        Worker(T[] array) {
            super(array);
        }

        @Override
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

    }

}
