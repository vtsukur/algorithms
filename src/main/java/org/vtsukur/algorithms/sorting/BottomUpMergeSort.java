package org.vtsukur.algorithms.sorting;

/**
 * @author volodymyr.tsukur
 */
public final class BottomUpMergeSort extends BaseSort {

    @Override
    public <T extends Comparable<T>> void sort(final T[] array) {
        new Worker<>(array).sort();
    }

    /**
     * @author volodymyr.tsukur
     */
    private final class Worker<T extends Comparable<T>> extends MergeSortWorker<T> {

        Worker(final T[] array) {
            super(array);
        }

        @Override
        void sort() {
            int factor = 1;
            while (factor < array.length) {
                final int size = factor * 2;
                int i;
                for (i = 0; i < array.length - factor; i += size) {
                    merge(i, i + factor, Math.min(i + size - 1, array.length - 1));
                }

                factor = size;
            }
        }

    }

}
