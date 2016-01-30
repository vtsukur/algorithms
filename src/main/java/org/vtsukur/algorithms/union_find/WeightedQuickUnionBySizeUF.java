package org.vtsukur.algorithms.union_find;

import java.util.Arrays;

/**
 * @author volodymyr.tsukur
 */
public final class WeightedQuickUnionBySizeUF extends AbstractUnionFind {

    private final int[] size;

    public WeightedQuickUnionBySizeUF(final int n) {
        super(n);
        size = new int[n];
        Arrays.fill(size, 1);
    }

    @Override
    public void union(final int p, final int q) {
        final int pRoot = root(p);
        final int qRoot = root(q);

        if (pRoot == qRoot) {
            return;
        }

        if (size[pRoot] >= size[qRoot]) {
            store[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            store[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
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
        return "weighted quick union (by size)";
    }

}
