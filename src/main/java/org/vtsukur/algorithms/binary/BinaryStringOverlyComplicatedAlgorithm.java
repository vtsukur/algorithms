package org.vtsukur.algorithms.binary;

/**
 * @author volodymyr.tsukur
 */
public final class BinaryStringOverlyComplicatedAlgorithm {

    public static String of(final int number) {
        if (number == 0) {
            return "0";
        }

        int boundary = 1, maxPowerOf2 = 1;
        while (boundary * 2 < number) {
            boundary *= 2;
            maxPowerOf2++;
        }
        char[] binary = new char[maxPowerOf2];

        int d = number, factor = maxPowerOf2;
        while (factor > 0) {
            if (d >= boundary) {
                binary[maxPowerOf2 - factor] = '1';
                d -= boundary;
            } else {
                binary[maxPowerOf2 - factor] = '0';
            }
            boundary /= 2;
            factor--;
        }

        return new String(binary);
    }

}
