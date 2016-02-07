package org.vtsukur.algorithms.sums;

import org.vtsukur.algorithms.search.BinarySearch;

import java.util.Arrays;

/**
 * @author volodymyr.tsukur
 */
public final class ThreeSumNSquaredLogN {

    public static int count(final int[] source) {
        final int[] sorted = Arrays.copyOf(source, source.length);
        Arrays.sort(sorted);
        return countSorted(sorted);
    }

    public static int countSorted(int[] sorted) {
        int times = 0;

        for (int i = 0; i < sorted.length; i++)
            for (int j = i + 1; j < sorted.length; j++) {
                final int index = BinarySearch.indexOf(sorted, -(sorted[i] + sorted[j]));
                if (index != -1 && index > j) {
                    times++;
                }
            }

        return times;
    }

}
