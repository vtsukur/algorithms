package org.vtsukur.algorithms.sorting;

/**
 * @author volodymyr.tsukur
 */
final class SortUtils {

    public static <T extends Comparable<T>> boolean less(final T left, final T right) {
        return left.compareTo(right) < 0;
    }

    public static <T extends Comparable<T>> void swap(final T[] array, final int i, final int j) {
        final T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
