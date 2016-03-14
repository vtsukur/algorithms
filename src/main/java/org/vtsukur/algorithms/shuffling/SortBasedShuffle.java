package org.vtsukur.algorithms.shuffling;

import java.util.Arrays;
import java.util.Random;

/**
 * @author volodymyr.tsukur
 */
public final class SortBasedShuffle extends BaseShuffle {

    @Override
    public <T> void shuffle(final T[] array) {
        @SuppressWarnings("unchecked") final Node<T>[] p = new Node[array.length];
        for (int i = 0; i < array.length; ++i) {
            p[i] = new Node<>(array[i]);
        }

        Arrays.sort(p);

        for (int i = 0; i < p.length; ++i) {
            array[i] = p[i].value;
        }
    }

    private static final class Node<T> implements Comparable<Node> {

        private static final Random RANDOM = new Random();

        final Double p = RANDOM.nextDouble();

        final T value;

        Node(final T value) {
            this.value = value;
        }

        @Override
        public int compareTo(@SuppressWarnings("NullableProblems") final Node other) {
            return p.compareTo(other.p);
        }

    }

}
