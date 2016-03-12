package org.vtsukur.algorithms.sorting;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Comparator;

/**
 * Uses array allocations for each recursive call to simplify the code.
 * Production-ready implementation should reuse a temporary array instead.
 *
 * @author volodymyr.tsukur
 */
public final class MergeSortAndInversionCount<T> {

    public Pair<T[], Long> sort(final T[] input, final Comparator<T> comparator) {
        return sort(input, comparator, 0, input.length - 1);
    }

    private Pair<T[], Long> sort(final T[] input, final Comparator<T> comparator, final int from, final int to) {
        final int distance = to - from + 1;
        if (1 == distance) {
            //noinspection unchecked
            return new ImmutablePair<>((T[]) new Object[] { input[from] }, 0L);
        }
        final int half = distance / 2;

        final int aftermath = from + half;
        final int rubicon = aftermath - 1;
        final Pair<T[], Long> left = sort(input, comparator, from, rubicon);
        final T[] leftArray = left.getLeft();
        final Pair<T[], Long> right = sort(input, comparator, aftermath, to);
        final T[] rightArray = right.getLeft();

        @SuppressWarnings("unchecked")
        final T[] result = (T[]) new Object[distance];
        int splitInversions = 0;
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (comparator.compare(leftArray[i], rightArray[j]) <= 0) {
                result[k++] = leftArray[i++];
            } else {
                splitInversions += leftArray.length - i;
                result[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            result[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            result[k++] = rightArray[j++];
        }

        return new ImmutablePair<>(result, left.getRight() + right.getRight() + splitInversions);
    }

}
