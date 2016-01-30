package org.vtsukur.algorithms.union_find;

import java.util.stream.IntStream;

/**
 * @author volodymyr.tsukur
 */
abstract class AbstractUnionFind implements UnionFind {

    protected final int[] store;

    AbstractUnionFind(final int n) {
        store = IntStream.rangeClosed(0, n - 1).toArray();
    }

    @Override
    public String toString() {
        return getName();
    }

    protected abstract String getName();

}
