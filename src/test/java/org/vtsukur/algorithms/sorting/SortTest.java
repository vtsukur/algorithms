package org.vtsukur.algorithms.sorting;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author volodymyr.tsukur
 */
@RunWith(Parameterized.class)
@RequiredArgsConstructor
public class SortTest {

    private final @NonNull Sort strategy;

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> strategies() {
        return Arrays.asList(new Object[][] {
                { new SelectionSort() },
                { new InsertionSort() },
                { new ShellSort() }
        });
    }

    @Test
    public void sort() {
        final Integer[] array = newRandomArray();

        strategy.sort(array);
        final Integer[] reference = referenceSortedArray(array);

        assertArrayEquals(array, reference);
    }

    private Integer[] newRandomArray() {
        final List<Integer> collection = IntStream.range(0, 100)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        Collections.shuffle(collection);
        return collection.toArray(new Integer[collection.size()]);
    }

    private Integer[] referenceSortedArray(Integer[] array) {
        final Integer[] reference = Arrays.copyOf(array, array.length);
        Arrays.sort(reference);
        return reference;
    }

}
