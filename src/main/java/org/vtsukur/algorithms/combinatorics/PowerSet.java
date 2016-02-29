package org.vtsukur.algorithms.combinatorics;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author volodymyr.tsukur
 */
public class PowerSet {

    public static void main(final String[] args) {
        List<Integer> universe = Arrays.asList(1, 2, 3);

        System.out.println("Method 1");
        findAllSubSetsV1(universe);

        System.out.println("Method 2");
        findAllSubSetsV2(universe);
    }

    // 0 => {}
    // 1 => {}, {1}
    // 2 => {}, {1}, {2}, {1, 2}
    // 3 => {}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}
    // N => { ... } of length 2^N

    private static void findAllSubSetsV1(List<Integer> universe) {
        List<List<Integer>> powerSet = new ArrayList<>();
        addAndPrint(Collections.emptyList(), powerSet);

        List<Integer> mutableUniverse = copy(universe);
        while (!mutableUniverse.isEmpty()) {
            Integer el = mutableUniverse.remove(0);
            final int n = powerSet.size();
            for (int i = 0; i < n; ++i) {
                List<Integer> newSet = copy(powerSet.get(i));
                newSet.add(el);
                addAndPrint(newSet, powerSet);
            }
        }
    }

    private static void addAndPrint(List<Integer> newSet, List<List<Integer>> powerSet) {
        powerSet.add(newSet);
        System.out.println(newSet);
    }

    private static List<Integer> copy(List<Integer> source) {
        return new ArrayList<>(source);
    }

    private static void findAllSubSetsV2(List<Integer> universe) {
        final int n = universe.size();
        BigInteger i = BigInteger.ZERO;
        BigInteger max = BigInteger.valueOf(2).pow(n);
        while (i.compareTo(max) < 0) {
            i = i.add(BigInteger.ONE);
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (i.testBit(j)) {
                    set.add(universe.get(j));
                }
            }
            System.out.println(set);
        }
    }

}
