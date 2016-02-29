package org.vtsukur.algorithms.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author volodymyr.tsukur
 */
public class MinMaxStackTest {

    @Test
    public void min_max() {
        final MinMaxStack<Integer> stack = new ArrayBasedMinMaxStack<>();

        stack.push(1);
        assertThat(stack.min(), is(1));
        assertThat(stack.max(), is(1));

        stack.push(2);
        assertThat(stack.min(), is(1));
        assertThat(stack.max(), is(2));

        stack.push(0);
        assertThat(stack.min(), is(0));
        assertThat(stack.max(), is(2));

        stack.pop();
        assertThat(stack.min(), is(1));
        assertThat(stack.max(), is(2));

        stack.push(5);
        assertThat(stack.min(), is(1));
        assertThat(stack.max(), is(5));

        stack.pop();
        assertThat(stack.min(), is(1));
        assertThat(stack.max(), is(2));

        stack.pop();
        assertThat(stack.min(), is(1));
        assertThat(stack.max(), is(1));
    }

}
