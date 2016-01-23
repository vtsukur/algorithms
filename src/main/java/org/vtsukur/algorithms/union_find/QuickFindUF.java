package org.vtsukur.algorithms.union_find;

import java.util.stream.IntStream;

/**
 * @author volodymyr.tsukur
 */
public final class QuickFindUF implements UnionFind {

    private final int[] store;

    QuickFindUF(final int n) {
        store = IntStream.rangeClosed(0, n).toArray();
    }

    @Override
    public void union(final int p, final int q) {
        if (connected(p, q)) {
            return;
        }

        final int find = store[p];
        final int replaceWith = store[q];
        for (int i = 0; i < store.length; ++i) {
            if (store[i] == find) {
                store[i] = replaceWith;
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return store[p] == store[q];
    }

}
