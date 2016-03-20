package org.vtsukur.algorithms.sorting;

import java.lang.reflect.Array;

import static org.vtsukur.algorithms.util.ComparableUtils.less;

/**
 * @author volodymyr.tsukur
 */
abstract class MergeSortWorker<T extends Comparable<T>> {

    final T[] array;

    final T[] aux;

    MergeSortWorker(final T[] array) {
        this.array = array;
        //noinspection unchecked
        aux = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
    }

    abstract void sort();

    final void merge(final int from, final int middle, final int to, final int size) {
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
