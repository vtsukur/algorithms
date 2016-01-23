package org.vtsukur.algorithms.union_find;

import java.util.Arrays;

/**
 * @author volodymyr.tsukur
 */
public final class WeightedQuickUnionUF extends AbstractUnionFind {

    private final int[] depths;

    public WeightedQuickUnionUF(final int n) {
        super(n);
        depths = new int[n];
        Arrays.fill(depths, 1);
    }

    @Override
    public void union(final int p, final int q) {
        final int pRoot = root(p);
        final int qRoot = root(q);

        if (depths[pRoot] == depths[qRoot]) {
            store[pRoot] = qRoot;
            depths[qRoot] += 1;
        } else if (depths[pRoot] < depths[qRoot]) {
            store[pRoot] = qRoot;
        } else {
            store[qRoot] = pRoot;
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
    protected String getName() {
        return "weighted quick union";
    }

}
