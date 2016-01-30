package org.vtsukur.algorithms.union_find;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author volodymyr.tsukur
 */
public class QuizTest {

    @Test
    public void quickFindQuiz() {
        final QuickFindUF uf = new QuickFindUF(10);
        uf.union(8, 3);
        uf.union(9, 6);
        uf.union(7, 0);
        uf.union(8, 9);
        uf.union(2, 9);
        uf.union(5, 9);
        System.out.println(IntStream.of(uf.store).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    @Test
    public void weightedQuickUnionQuiz() {
        final WeightedQuickUnionBySizeUF uf = new WeightedQuickUnionBySizeUF(10);
        uf.union(3, 5);
        uf.union(0, 9);
        uf.union(2, 6);
        uf.union(9, 7);
        uf.union(9, 5);
        uf.union(8, 4);
        uf.union(4, 2);
        uf.union(0, 1);
        uf.union(2, 1);
        System.out.println(IntStream.of(uf.store).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

}
