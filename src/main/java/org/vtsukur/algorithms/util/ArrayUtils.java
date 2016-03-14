package org.vtsukur.algorithms.util;

/**
 * @author volodymyr.tsukur
 */
public final class ArrayUtils {

    public static <T> void swap(final T[] array, final int i, final int j) {
        final T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
