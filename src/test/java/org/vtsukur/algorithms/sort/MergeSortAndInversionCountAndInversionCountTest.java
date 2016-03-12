package org.vtsukur.algorithms.sort;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author volodymyr.tsukur
 */
public class MergeSortAndInversionCountAndInversionCountTest {

    @Test
    public void eightNumbers() {
        final Integer[] array = { 5, 8, 1, 3, 7, 4, 6, 2 };

        final Pair<Integer[], Long> result = new MergeSortAndInversionCount<Integer>().sort(array, Comparator.<Integer>naturalOrder());

        Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, result.getLeft());
        Assert.assertEquals(16L, result.getRight().longValue());
    }

    @Test
    public void sixNumbers() {
        final Integer[] array = { 1, 3, 5, 2, 4, 6 };

        final Pair<Integer[], Long> result = new MergeSortAndInversionCount<Integer>().sort(array, Comparator.<Integer>naturalOrder());

        Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6 }, result.getLeft());
        Assert.assertEquals(3L, result.getRight().longValue());
    }

    @Test
    public void oneHundredThousandNumbers() throws URISyntaxException, IOException {
        final List<Integer> numbers = Files.lines(Paths.get(getClass().getResource("100k_numbers.txt").toURI()))
                .filter(line -> line != null && !line.isEmpty())
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        final Integer[] array = numbers.toArray(new Integer[numbers.size()]);

        final Pair<Integer[], Long> result = new MergeSortAndInversionCount<Integer>().sort(array, Comparator.<Integer>naturalOrder());

        // double-checking input
        Arrays.sort(array);
        final int SIZE = 100000;
        Assert.assertEquals(array.length, SIZE);
        Assert.assertEquals(array[0].intValue(), 1);
        Assert.assertEquals(array[array.length - 1].intValue(), SIZE);

        Assert.assertArrayEquals(array, result.getLeft());
        Assert.assertEquals(2407905288L, result.getRight().longValue());
    }

}
