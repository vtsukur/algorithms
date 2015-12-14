package org.vtsukur.algorithms.divide_and_conquer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author volodymyr.tsukur
 */
public class KaratsubaMultiplicationTest {

    @Test
    public void fourDigitMultiplication() {
        final int first = 1234;
        final int second = 5678;

        final int product = new KaratsubaMultiplication().multiply(first, second, 4);

        Assert.assertEquals(first * second, product);
    }

}
