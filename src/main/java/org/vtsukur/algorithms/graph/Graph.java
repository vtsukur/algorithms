package org.vtsukur.algorithms.graph;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * @author volodymyr.tsukur
 */
public final class Graph {

    private final Collection<Node> nodes;

    public Graph(final Node ... nodes) {
        this.nodes = Arrays.asList(nodes);
    }

    public Map<Node, Integer> calculateShortestPaths(final Node from) {
        return new DijkstraShortestPaths(this).calculate(from);
    }

    public int n() {
        return nodes.size();
    }

}
