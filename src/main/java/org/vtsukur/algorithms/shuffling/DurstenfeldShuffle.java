package org.vtsukur.algorithms.shuffling;

import org.vtsukur.algorithms.util.ArrayUtils;

import java.util.Random;

/**
 * @author volodymyr.tsukur
 */
public final class DurstenfeldShuffle extends BaseShuffle {

    private static final Random RANDOM = new Random();

    @Override
    public <T> void shuffle(final T[] array) {
        for (int i = 0; i < array.length; ++i) {
            final int r = RANDOM.nextInt(i + 1);
            ArrayUtils.swap(array, i, r);
        }
    }

}
