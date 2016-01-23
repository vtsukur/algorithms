package org.vtsukur.algorithms.union_find;

public interface UnionFind {

    void union(int p, int q);

    boolean connected(int p, int q);

}
