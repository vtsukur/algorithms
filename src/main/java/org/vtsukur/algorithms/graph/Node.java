package org.vtsukur.algorithms.graph;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author volodymyr.tsukur
 */
public final class Node {

    private final Collection<Edge> edges = new ArrayList<>();

    public void to(final Node to, final int weight) {
        edges.add(new Edge(this, to, weight));
    }

    public Collection<Edge> edges() {
        return edges;
    }

}
