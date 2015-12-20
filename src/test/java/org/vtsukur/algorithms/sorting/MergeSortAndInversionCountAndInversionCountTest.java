package org.vtsukur.algorithms.sorting;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author volodymyr.tsukur
 */
public class MergeSortAndInversionCountAndInversionCountTest {

    @Test
    public void eightNumbers() {
        final int[] array = { 5, 8, 1, 3, 7, 4, 6, 2 };

        final Pair<int[], Integer> result = new MergeSortAndInversionCount().sort(array);

        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, result.getLeft());
        Assert.assertEquals((Integer) 16, result.getRight());
    }

    @Test
    public void sixNumbers() {
        final int[] array = { 1, 3, 5, 2, 4, 6 };

        final Pair<int[], Integer> result = new MergeSortAndInversionCount().sort(array);

        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, result.getLeft());
        Assert.assertEquals((Integer) 3, result.getRight());
    }

    @Test
    public void oneHundredThousandNumbers() throws URISyntaxException, IOException {
        final int[] array = Files.lines(Paths.get(getClass().getResource("100k_numbers.txt").toURI()))
                .filter(line -> line != null && !line.isEmpty())
                .mapToInt(Integer::valueOf)
                .toArray();

        final Pair<int[], Integer> result = new MergeSortAndInversionCount().sort(array);

        Arrays.sort(array);
        Assert.assertArrayEquals(array, result.getLeft());
//        Assert.assertEquals((Integer) 3, result.getRight());
    }

}
