package org.vtsukur.algorithms.shuffling;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author volodymyr.tsukur
 */
@RunWith(Parameterized.class)
@RequiredArgsConstructor
public class ShufflingTest {

    private final @NonNull Shuffle shuffle;

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> strategies() {
        return Arrays.asList(new Object[][] {
                { new DurstenfeldShuffle() },
                { new SortBasedShuffle() }
        });
    }

    @Test
    public void test() {
        final Integer[] array = newRange(0, 100);
        final List<Integer> reference = copyOfAsList(array);

        shuffle.shuffle(array);
        System.out.println(Arrays.toString(array));

        // TODO test that shuffling is "really" random

        final Double[] probabilities = new Double[array.length + 1];
        probabilities[array.length - 1] = 0.0;
        probabilities[array.length] = 1.0;
        for (int i = 0; i < array.length - 1; ++i) {
            final Integer selection = array[i];
            final int originalPosition = reference.indexOf(selection);
            final double remainingLength = array.length - i;
            final double pLowerBound = (originalPosition - i) / remainingLength;
            final double pUpperBound = (originalPosition - i + 1) / remainingLength;
            probabilities[i] = (pUpperBound + pLowerBound) / 2;
            final Integer swapWith = reference.get(i);
            reference.set(i, selection);
            reference.set(originalPosition, swapWith);
            System.out.println(probabilities[i]);
        }
    }

    private static Integer[] newRange(final int startInclusive, final int endExclusive) {
        return IntStream.range(startInclusive, endExclusive)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList())
                .toArray(new Integer[endExclusive - startInclusive]);
    }

    private static List<Integer> copyOfAsList(final Integer[] array) {
        return Arrays.asList(Arrays.copyOf(array, array.length));
    }

}
