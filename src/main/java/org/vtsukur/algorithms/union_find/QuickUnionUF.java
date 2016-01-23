package org.vtsukur.algorithms.union_find;

/**
 * @author volodymyr.tsukur
 */
public class QuickUnionUF extends AbstractUnionFind {

    QuickUnionUF(final int n) {
        super(n);
    }

    @Override
    public void union(final int p, final int q) {
        final int pRoot = root(p);
        final int qRoot = root(q);
        store[pRoot] = qRoot;
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
    public String getName() {
        return "quick union";
    }

}
