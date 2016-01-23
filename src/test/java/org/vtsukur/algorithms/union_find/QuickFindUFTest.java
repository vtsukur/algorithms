package org.vtsukur.algorithms.union_find;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author volodymyr.tsukur
 */
@RunWith(Parameterized.class)
public class QuickFindUFTest {

    private static final int N = 10;

    private static final AssertableTestEntry[] ASSERTABLE_INPUT = new AssertableTestEntry[] {
            new AssertableTestEntry(4, 3, false),
            new AssertableTestEntry(3, 8, false),
            new AssertableTestEntry(5, 6, false),
            new AssertableTestEntry(9, 4, false),
            new AssertableTestEntry(2, 1, false),
            new AssertableTestEntry(8, 9, true),
            new AssertableTestEntry(5, 0, false),
            new AssertableTestEntry(7, 2, false),
            new AssertableTestEntry(6, 1, false),
            new AssertableTestEntry(0, 7, true),
            new AssertableTestEntry(2, 5, true),
            new AssertableTestEntry(8, 4, true),
            new AssertableTestEntry(2, 3, false),
            new AssertableTestEntry(0, 9, true),
    };

    private final QuickFindUF uf;

    public QuickFindUFTest(final Object uf) {
        this.uf = (QuickFindUF) uf;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> algorithms() {
        return Arrays.asList(new Object[][] {
                { new QuickFindUF(N) }
        });
    }

    @Test
    public void test() {
        Arrays.stream(ASSERTABLE_INPUT).forEach(input -> {
            final boolean connected = uf.connected(input.p, input.q);
            assertThat(input.connected, equalTo(connected));
            if (!connected) {
                uf.union(input.p, input.q);
            }
        });
    }

    /**
     * @author volodymyr.tsukur
     */
    private static class AssertableTestEntry {

        final int p;

        final int q;

        final boolean connected;

        private AssertableTestEntry(final int p, final int q, final boolean connected) {
            this.p = p;
            this.q = q;
            this.connected = connected;
        }

    }

}
