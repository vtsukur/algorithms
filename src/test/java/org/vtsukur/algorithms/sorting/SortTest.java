package org.vtsukur.algorithms.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author volodymyr.tsukur
 */
@RunWith(Parameterized.class)
public class SortTest {

    private final Sort<Integer> strategy;

    public SortTest(final Sort<Integer> strategy) {
        this.strategy = strategy;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> strategies() {
        return Arrays.asList(new Object[][] {
                { new SelectionSort<Integer>() },
                { new InsertionSort<Integer>() }
        });
    }

    @Test
    public void sort() {
        final Integer[] array = new Integer[] { 7, 10, 5, 3, 8, 4, 2, 9, 6 };
        strategy.sort(array);
        assertArrayEquals(array, new Integer[] { 2, 3, 4, 5, 6, 7, 8, 9, 10 });
    }

}
