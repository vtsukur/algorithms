package org.vtsukur.algorithms.sums;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author volodymyr.tsukur
 */
public final class ThreeSumNSquared {

    public static int count(final int[] source) {
        final int[] sorted = Arrays.copyOf(source, source.length);
        Arrays.sort(sorted);

        final Map<Integer, Integer> unique = new LinkedHashMap<>();
        for (int i = 0; i < source.length; ++i)
            unique.put(source[i], i);

        int times = 0;

        for (int i = 0; i < sorted.length; i++)
            for (int j = i + 1; j < sorted.length; j++) {
                final int lookup = -(sorted[i] + sorted[j]);
                final Integer position = unique.get(lookup);
                if (position != null && position > j) times++;
            }

        return times;
    }

}
