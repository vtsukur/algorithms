package org.vtsukur.algorithms.sums;

import java.util.Arrays;

/**
 * @author volodymyr.tsukur
 */
public final class ThreeSumNSquaredMatrix {

    public static int count(final int[] source) {
        final int[] sorted = Arrays.copyOf(source, source.length);
        Arrays.sort(sorted);
        return countSorted(sorted);
    }

    public static int countSorted(final int[] sorted) {
        int times = 0;

        for (int i = 0; i < sorted.length; i++) {
            int searchPointer = sorted.length - 1;
            for (int j = i + 1; j < sorted.length; j++) {
                final int target = -(sorted[i] + sorted[j]);
                while (target < sorted[searchPointer] && searchPointer > 0) {
                    searchPointer--;
                }
                if (target == sorted[searchPointer] && searchPointer > j) {
                    times++;
                }
            }
        }

        return times;
    }

}
