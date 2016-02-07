package org.vtsukur.algorithms.sums;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author volodymyr.tsukur
 */
public class ThreeSumTest {

    final int[] SOURCE = { 30, -40, -20, -10, 40, 0, 10, 5 };

    @Test
    public void n_cubic_algorithm_count() {
        assertThat(ThreeSumNCubic.count(SOURCE), is(4));
    }

    @Test
    public void n_squared_log_n_algorithm_count() {
        assertThat(ThreeSumNSquaredLogN.count(SOURCE), is(4));
    }

    @Test
    public void n_squared_hash_table_algorithm_count() {
        assertThat(ThreeSumNSquaredHashTable.count(SOURCE), is(4));
    }

    @Test
    public void n_squared_matrix_algorithm_count() {
        assertThat(ThreeSumNSquaredMatrix.count(SOURCE), is(4));
    }

}
