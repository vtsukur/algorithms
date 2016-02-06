package org.vtsukur.algorithms.sums;

/**
 * @author volodymyr.tsukur
 */
public final class ThreeSumNCubic {

    public static int count(final int[] source) {
        int times = 0;

        for (int i = 0; i < source.length; i++)
            for (int j = i + 1; j < source.length; j++)
                for (int k = j + 1; k < source.length; k++)
                    if (source[i] + source[j] + source[k] == 0) times++;

        return times;
    }

}
