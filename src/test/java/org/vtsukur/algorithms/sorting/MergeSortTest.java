package org.vtsukur.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author volodymyr.tsukur
 */
public class MergeSortTest {

    @Test
    public void sort() {
        final int[] array = { 5, 8, 1, 3, 7, 4, 6, 2 };

        final int[] result = new MergeSort().sort(array);

        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, result);
    }

}
