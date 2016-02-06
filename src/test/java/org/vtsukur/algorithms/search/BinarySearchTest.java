package org.vtsukur.algorithms.search;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author volodymyr.tsukur
 */
public class BinarySearchTest {

    final int[] SOURCE = { 1, 3, 5, 7, 9, 11, 12, 14, 16, 18, 20 };

    @Test
    public void find_all() {
        for (int i = 0; i < SOURCE.length; ++i) {
            assertThat(BinarySearch.indexOf(SOURCE, SOURCE[i]), is(i));
        }
    }

    @Test
    public void do_not_find() {
        assertThat(BinarySearch.indexOf(SOURCE, 10), is(-1));
    }

    @Test
    public void do_not_find_in_empty() {
        assertThat(BinarySearch.indexOf(new int[] {}, 10), is(-1));
    }

    @Test
    public void find_in_single_element_array() {
        assertThat(BinarySearch.indexOf(new int[] { 10 }, 10), is(0));
    }

}
