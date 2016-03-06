package org.vtsukur.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author volodymyr.tsukur
 */
public class SelectionSortTest {

    @Test
    public void sort() {
        final Integer[] array = new Integer[] { 7, 10, 5, 3, 8, 4, 2, 9, 6 };
        SelectionSort.sort(array);
        assertArrayEquals(array, new Integer[] { 2, 3, 4, 5, 6, 7, 8, 9, 10 });
    }

}
