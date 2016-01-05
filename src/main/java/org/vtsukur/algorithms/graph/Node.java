package org.vtsukur.algorithms.graph;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author volodymyr.tsukur
 */
public final class Node {

    private final String name;

    private final Collection<Edge> edges = new ArrayList<>();

    public Node(final String name) {
        this.name = name;
    }

    public void to(final Node to, final int weight) {
        edges.add(new Edge(this, to, weight));
    }

    public Collection<Edge> edges() {
        return edges;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }

}
