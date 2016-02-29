package org.vtsukur.algorithms.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author volodymyr.tsukur
 */
@RunWith(Parameterized.class)
public class StackTest {

    private final Builder builder;

    public StackTest(final Provider provider) {
        this.builder = provider.builder;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> implementations() {
        return Arrays.asList(new Object[][]{
                {new Provider(CustomLinkedListBasedStack::new, "based on custom implementation of linked list")},
                {new Provider(LinkedListBasedStack::new, "based on linked list")},
                {new Provider(ArrayBasedStack::new, "based on resizable array")},
                {new Provider(ArrayBasedMinMaxStack::new, "based on resizable array with support for min and max")}
        });
    }

    @Test
    public void test() {
        final Stack<String> stack = builder.build();

        stack.push("5");
        assertSizeAndEmptyFlag(stack, 1);
        assertPeekAndPop(stack, "5");
        assertSizeAndEmptyFlag(stack, 0);

        stack.push("4");
        assertSizeAndEmptyFlag(stack, 1);
        stack.push("3");
        assertSizeAndEmptyFlag(stack, 2);
        assertPeekAndPop(stack, "3");
        assertSizeAndEmptyFlag(stack, 1);
        assertPeekAndPop(stack, "4");
        assertSizeAndEmptyFlag(stack, 0);

        stack.push("2");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        stack.push("10");
        assertSizeAndEmptyFlag(stack, 6);
        assertPeekAndPop(stack, "10");
        assertPeekAndPop(stack, "9");
        assertPeekAndPop(stack, "8");
        assertPeekAndPop(stack, "7");
        assertPeekAndPop(stack, "6");
        assertPeekAndPop(stack, "2");
        assertSizeAndEmptyFlag(stack, 0);

        stack.push("1");
        assertSizeAndEmptyFlag(stack, 1);
        assertPeekAndPop(stack, "1");
        assertSizeAndEmptyFlag(stack, 0);
    }

    @Test
    public void iterator() {
        final Stack<String> stack = builder.build();

        stack.push("1");
        stack.push("2");
        stack.push("3");

        Iterator<String> i = stack.iterator();
        assertTrue(i.hasNext());
        assertEquals(i.next(), "3");
        assertTrue(i.hasNext());
        assertEquals(i.next(), "2");
        assertTrue(i.hasNext());
        assertEquals(i.next(), "1");
        assertFalse(i.hasNext());
    }

    private static void assertSizeAndEmptyFlag(final Stack stack, final int expectedSize) {
        assertEquals(stack.size(), expectedSize);
        assertEquals(stack.isEmpty(), expectedSize == 0);
    }

    private static <T> void assertPeekAndPop(final Stack<T> stack, final T expected) {
        assertEquals(stack.peek(), expected);
        assertEquals(stack.pop(), expected);
    }

    /**
     * @author volodymyr.tsukur
     */
    private static final class Provider {

        private final Builder builder;

        private final String name;

        public Provider(final Builder builder, final String name) {
            this.builder = builder;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * @author volodymyr.tsukur
     */
    private interface Builder {

        Stack<String> build();

    }

}
