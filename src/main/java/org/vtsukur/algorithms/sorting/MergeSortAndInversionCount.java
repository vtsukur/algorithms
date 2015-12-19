package org.vtsukur.algorithms.sorting;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Uses array allocations for each recursive call to simplify the code.
 * Production-ready implementation should reuse a temporary array instead.
 *
 * @author volodymyr.tsukur
 */
public final class MergeSortAndInversionCount {

    public Pair<int[], Integer> sort(final int[] input) {
        return sort(input, 0, input.length - 1);
    }

    private Pair<int[], Integer> sort(final int[] input, final int from, final int to) {
        final int distance = to - from + 1;
        if (1 == distance) {
            return new ImmutablePair<>(new int[] { input[from] }, 0);
        }
        final int half = distance / 2;

        final int aftermath = from + half;
        final int rubicon = aftermath - 1;
        final Pair<int[], Integer> left = sort(input, from, rubicon);
        final int[] leftArray = left.getLeft();
        final Pair<int[], Integer> right = sort(input, aftermath, to);
        final int[] rightArray = right.getLeft();

        final int[] result = new int[distance];
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                result[k++] = leftArray[i++];
            } else {
                result[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            result[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            result[k++] = rightArray[j++];
        }
        return new ImmutablePair<>(result, 0);
    }

}
