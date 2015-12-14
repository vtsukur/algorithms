package org.vtsukur.algorithms.divide_and_conquer;

import java.util.stream.IntStream;

/**
 * @author volodymyr.tsukur
 */
public final class KaratsubaMultiplication {

    public int multiply(final int first, final int second, final int n) {
        if (n == 1) {
            return first * second;
        }

        final int halfN = n / 2;

        final int tenPowerN = pow(10, n);
        final int tenPowerHalfN = pow(10, halfN);

        final int b = first % tenPowerHalfN;
        final int a = (first - b) / tenPowerHalfN;
        final int d = second % tenPowerHalfN;
        final int c = (second - d) / tenPowerHalfN;

        final int ac = multiply(a, c, halfN);
        final int bd = multiply(b, d, halfN);

        final int aPlusB = a + b;
        final int cPlusD = c + d;
        final int aPlusBcPlusD = multiply(aPlusB, cPlusD, halfN);
        final int adPlusBc = aPlusBcPlusD - ac - bd;

        return ac * tenPowerN + adPlusBc * tenPowerHalfN + bd;
    }

    private int pow(final int base, final int power) {
        if (0 == power) {
            return 1;
        }
        return IntStream.range(1, power).reduce(base, (value, i) -> value * base);
    }

}
