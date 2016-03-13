package org.vtsukur.algorithms.sorting;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
        val array = newRandomArray(100);

        strategy.sort(array);
        val reference = referenceSortedArray(array);

        assertArrayEquals(array, reference);
    }

    private static Integer[] newRandomArray(final int size) {
        val collection = IntStream.range(0, size)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        Collections.shuffle(collection);
        return collection.toArray(new Integer[collection.size()]);
    }

    private static Integer[] referenceSortedArray(final Integer[] array) {
        val reference = Arrays.copyOf(array, array.length);
        Arrays.sort(reference);
        return reference;
    }

}
