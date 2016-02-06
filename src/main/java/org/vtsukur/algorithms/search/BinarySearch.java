package org.vtsukur.algorithms.search;

/**
 * @author volodymyr.tsukur
 */
public final class BinarySearch {

    public static int indexOf(final int[] source, final int i) {
        int index = -1;

        int l = 0, r = source.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (source[m] > i) {
                r = m - 1;
            } else if (source[m] < i){
                l = m + 1;
            } else {
                index = m;
                break;
            }
        }

        return index;
    }

}
