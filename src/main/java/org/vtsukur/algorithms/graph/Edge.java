package org.vtsukur.algorithms.graph;

/**
 * @author volodymyr.tsukur
 */
public final class Edge {

    private final Node from;

    private final Node to;

    private final int weight;

    public Edge(final Node from, final Node to, final int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Node to() {
        return to;
    }

    public int weight() {
        return weight;
    }

}
