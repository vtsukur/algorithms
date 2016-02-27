package org.vtsukur.algorithms.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author volodymyr.tsukur
 */
@RunWith(Parameterized.class)
public class StackPushPopSequenceTest {

    private final IntArray sequence;

    private final boolean valid;

    public StackPushPopSequenceTest(final IntArray sequence, final boolean valid) {
        this.sequence = sequence;
        this.valid = valid;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> implementations() {
        return Arrays.asList(new Object[][]{
                {new IntArray(1, 3, 0, 6, 5, 4, 7, 2, 8, 9), false},
                {new IntArray(2, 3, 1, 0, 4, 5, 7, 6, 8, 9), true},
                {new IntArray(3, 2, 1, 0, 4, 5, 6, 7, 8, 9), true},
                {new IntArray(3, 5, 7, 8, 6, 9, 4, 2, 1, 0), true},
                {new IntArray(3, 2, 5, 1, 4, 0, 6, 7, 8, 9), false}
        });
    }

    @Test
    public void test() {
        assertThat(StackPushPopSequence.isValid(sequence.values), is(valid));
    }

    /**
     * @author volodymyr.tsukur
     */
    private static final class IntArray {

        final int[] values;

        public IntArray(final int... values) {
            this.values = values;
        }

        @Override
        public String toString() {
            return Arrays.toString(values);
        }

    }

}
