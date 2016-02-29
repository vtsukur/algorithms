package org.vtsukur.algorithms.combinatorics;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author volodymyr.tsukur
 */
public class Bits {

    public static void main(final String[] args) {
        printBits(3);
        printAllSubSets(Arrays.asList(1, 2, 3));
    }

    private static void printBits(int n) {
        byte[] bits = new byte[n + 1];

        int i = 0;
        while (i != n) {
            i = 0;
            while (bits[i] == 1) {
                bits[i++] = 0;
            }
            bits[i] = 1;

            System.out.println(Arrays.toString(bits));
        }
    }

    private static void printAllSubSets(List<Integer> universe) {
        int n = universe.size();
        byte[] bits = new byte[n + 1];

        TreeSet<Integer> set = new TreeSet<>();
        int i = 0;
        while (i != n) {
            i = 0;
            while (bits[i] == 1) {
                bits[i] = 0;
                set.remove(universe.get(i));
                i++;
            }
            bits[i] = 1;
            if (i != n) {
                set.add(universe.get(i));
            }
            System.out.println(set);
        }
    }

}
