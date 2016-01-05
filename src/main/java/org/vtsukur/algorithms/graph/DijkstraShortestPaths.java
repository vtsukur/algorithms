package org.vtsukur.algorithms.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author volodymyr.tsukur
 */
public final class DijkstraShortestPaths {

    private final Graph graph;

    public DijkstraShortestPaths(final Graph graph) {
        this.graph = graph;
    }

    public Map<Node, Integer> calculate(final Node from) {
        final Map<Node, Integer> shortestPaths = new HashMap<>();
        shortestPaths.put(from, 0);

        while (shortestPaths.size() < graph.n()) {
            int minDistance = 0;
            Node next = null;

            for (final Map.Entry<Node, Integer> entry : shortestPaths.entrySet()) {
                final Node node = entry.getKey();
                final int startDistance = entry.getValue();
                for (final Edge edge : node.edges()) {
                    final Node to = edge.to();
                    if (!shortestPaths.containsKey(to)) {
                        final int d = startDistance + edge.weight();
                        if (next == null || d < minDistance) {
                            minDistance = d;
                            next = to;
                        }
                    }
                }
            }

            shortestPaths.put(next, minDistance);
        }

        return shortestPaths;
    }

}
