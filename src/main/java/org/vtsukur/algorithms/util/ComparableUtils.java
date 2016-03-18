package org.vtsukur.algorithms.util;

/**
 * @author volodymyr.tsukur
 */
public final class ComparableUtils {

    public static <T extends Comparable<T>> boolean less(final T left, final T right) {
        return left.compareTo(right) < 0;
    }

    public static <T extends Comparable<T>> boolean lessOrEqualTo(final T left, final T right) {
        return left.compareTo(right) <= 0;
    }

}
