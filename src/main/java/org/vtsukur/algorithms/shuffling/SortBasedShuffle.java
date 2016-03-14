package org.vtsukur.algorithms.shuffling;

import java.util.Random;

/**
 * @author volodymyr.tsukur
 */
public final class SortBasedShuffle implements Shuffle {

    private static final Random RANDOM = new Random();

    @Override
    public <T> void shuffle(final T[] array) {
        for (int i = 0; i < array.length; ++i) {
            final int r = RANDOM.nextInt(i + 1);
            final T t = array[i];
            array[i] = array[r];
            array[r] = t;
        }
    }

}
