package org.vtsukur.algorithms.sums;

import org.vtsukur.algorithms.search.BinarySearch;

import java.util.Arrays;

/**
 * @author volodymyr.tsukur
 */
public final class ThreeSumNSquaredLogN {

    public static int count(final int[] source) {
        final int[] cpy = Arrays.copyOf(source, source.length);
        Arrays.sort(cpy);

        int times = 0;

        for (int i = 0; i < cpy.length; i++)
            for (int j = i + 1; j < cpy.length; j++) {
                final int index = BinarySearch.indexOf(cpy, -(cpy[i] + cpy[j]));
                if (index != -1 && index > j) {
                    times++;
                }
            }

        return times;
    }

}
