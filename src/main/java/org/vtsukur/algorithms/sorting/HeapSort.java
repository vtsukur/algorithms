package org.vtsukur.algorithms.sorting;

import static org.vtsukur.algorithms.priority_queue.HeapOrderedMaxPriorityQueue.heapify;
import static org.vtsukur.algorithms.priority_queue.HeapOrderedMaxPriorityQueue.sink;
import static org.vtsukur.algorithms.util.ArrayUtils.swap;

/**
 * @author volodymyr.tsukur
 */
public final class HeapSort extends BaseSort {

    @Override
    public <T extends Comparable<T>> void sort(final T[] array) {
        heapify(array);
        for (int i = array.length - 1; i > 0; --i) {
            swap(array, 0, i);
            sink(array, i, 0);
        }
    }

}
