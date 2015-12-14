package org.vtsukur.algorithms.divide_and_conquer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author volodymyr.tsukur
 */
public class KaratsubaMultiplicationTest {

    @Test
    public void fourDigitMultiplication() {
        final long first = 1234;
        final long second = 5678;

        final long product = new KaratsubaMultiplication().multiply(first, second, 4);

        Assert.assertEquals(first * second, product);
    }

}
