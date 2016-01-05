package org.vtsukur.algorithms.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author volodymyr.tsukur
 */
public class DijkstraShortestPathsTest {

    @Test
    public void fourNodes() {
        final Node s = new Node();
        final Node u = new Node();
        final Node w = new Node();
        final Node t = new Node();

        s.to(u, 1);
        s.to(w, 4);
        u.to(w, 2);
        u.to(t, 6);
        w.to(t, 3);

        final Graph graph = new Graph(s, u, w, t);
        final Map<Node, Integer> shortestPaths = graph.calculateShortestPaths(s);

        Assert.assertEquals(shortestPaths.get(s), (Integer) 0);
        Assert.assertEquals(shortestPaths.get(u), (Integer) 1);
        Assert.assertEquals(shortestPaths.get(w), (Integer) 3);
        Assert.assertEquals(shortestPaths.get(t), (Integer) 6);
    }

}
