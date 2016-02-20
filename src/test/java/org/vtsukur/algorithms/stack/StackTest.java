package org.vtsukur.algorithms.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author volodymyr.tsukur
 */
@RunWith(Parameterized.class)
public class StackTest {

    private final Stack<String> stack;

    public StackTest(final Stack<String> stack) {
        this.stack = stack;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> implementations() {
        return Arrays.asList(new Object[][]{
                {new CustomLinkedListBasedStack()},
                {new LinkedListBasedStack()},
                {new ArrayBasedStack()}
        });
    }

    @Test
    public void test() {
        stack.push("5");
        assertSizeAndEmptyFlag(stack, 1);
        assertEquals(stack.pop(), "5");
        assertSizeAndEmptyFlag(stack, 0);

        stack.push("4");
        assertSizeAndEmptyFlag(stack, 1);
        stack.push("3");
        assertSizeAndEmptyFlag(stack, 2);
        assertEquals(stack.pop(), "3");
        assertSizeAndEmptyFlag(stack, 1);
        assertEquals(stack.pop(), "4");
        assertSizeAndEmptyFlag(stack, 0);

        stack.push("1");
        assertSizeAndEmptyFlag(stack, 1);
        assertEquals(stack.pop(), "1");
        assertSizeAndEmptyFlag(stack, 0);

        stack.push("2");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        stack.push("10");
        assertSizeAndEmptyFlag(stack, 6);
        assertEquals(stack.pop(), "10");
        assertEquals(stack.pop(), "9");
        assertEquals(stack.pop(), "8");
        assertEquals(stack.pop(), "7");
        assertEquals(stack.pop(), "6");
        assertEquals(stack.pop(), "2");
        assertSizeAndEmptyFlag(stack, 0);
    }

    private static void assertSizeAndEmptyFlag(final Stack stack, final int expectedSize) {
        assertEquals(stack.size(), expectedSize);
        assertEquals(stack.isEmpty(), expectedSize == 0);
    }

}
