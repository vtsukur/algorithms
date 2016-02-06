package org.vtsukur.algorithms.sums;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author volodymyr.tsukur
 */
public class ThreeSumNCubicTest {

    @Test
    public void count() {
        final int[] source = { 30, -40, -20, -10, 40, 0, 10, 5 };

        assertThat(ThreeSumNCubic.count(source), is(4));
    }

}
