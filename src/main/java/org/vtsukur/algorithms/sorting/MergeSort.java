package org.vtsukur.algorithms.sorting;

/**
 * Uses array allocations for each recursive call to simplify the code.
 * Production-ready implementation should reuse a temporary array instead.
 *
 * @author volodymyr.tsukur
 */
public final class MergeSort {

    public int[] sort(final int[] input) {
        return sort(input, 0, input.length - 1);
    }

    private int[] sort(final int[] input, final int from, final int to) {
        final int distance = to - from + 1;
        if (1 == distance) {
            return new int[] { input[from] };
        }
        final int half = distance / 2;

        final int aftermath = from + half;
        final int rubicon = aftermath - 1;
        final int[] left = sort(input, from, rubicon);
        final int[] right = sort(input, aftermath, to);

        final int[] result = new int[distance];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }

}
