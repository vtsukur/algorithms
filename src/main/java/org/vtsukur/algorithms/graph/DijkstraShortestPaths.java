package org.vtsukur.algorithms.graph;

import java.util.*;
import java.util.stream.Collectors;

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

        final Set<Edge> candidateEdges = new HashSet<>();
        addCandidateEdges(candidateEdges, from);

        while (shortestPaths.size() < graph.n()) {
            int minDistance = 0;
            Node next = null;

            for (final Edge edge : candidateEdges) {
                final Node to = edge.to();
                final int d = shortestPaths.get(edge.from()) + edge.weight();
                if (next == null || d < minDistance) {
                    minDistance = d;
                    next = to;
                }
            }

            final Collection<Edge> toRemove = new ArrayList<>();
            for (final Edge edge : candidateEdges) {
                if (edge.to().equals(next)) {
                    toRemove.add(edge);
                }
            }
            candidateEdges.removeAll(toRemove);
            for (final Edge edge : next.edges()) {
                if (shortestPaths.containsKey(edge.to())) {
                    candidateEdges.remove(edge);
                } else {
                    candidateEdges.add(edge);
                }
            }

            shortestPaths.put(next, minDistance);
        }

        return shortestPaths;
    }

    private void addCandidateEdges(final Set<Edge> edges, final Node node) {
        edges.addAll(node.edges().stream().collect(Collectors.toList()));
    }

}
