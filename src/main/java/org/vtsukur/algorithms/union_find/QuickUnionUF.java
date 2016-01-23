package org.vtsukur.algorithms.union_find;

import java.util.stream.IntStream;

/**
 * @author volodymyr.tsukur
 */
public class QuickUnionUF implements UnionFind {

    private final int[] store;

    QuickUnionUF(final int n) {
        store = IntStream.rangeClosed(0, n).toArray();
    }

    @Override
    public void union(final int p, final int q) {
        final int pRoot = root(p);
        final int qRoot = root(q);
        if (pRoot != qRoot) {
            store[pRoot] = qRoot;
        }
    }

    @Override
    public boolean connected(final int p, final int q) {
        return root(p) == root(q);
    }

    private int root(final int of) {
        int i = of;
        while (store[i] != i) {
            i = store[i];
        }
        return i;
    }

    @Override
    public String toString() {
        return "quick union";
    }

}
