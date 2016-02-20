package org.vtsukur.algorithms.queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * @author volodymyr.tsukur
 */
@RunWith(Parameterized.class)
public class QueueTest {

    private final Builder builder;

    public QueueTest(final Provider provider) {
        this.builder = provider.builder;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> implementations() {
        return Arrays.asList(new Object[][]{
                {new Provider(CustomLinkedListBasedQueue::new, "based on custom implementation of linked list")},
                {new Provider(LinkedListBasedQueue::new, "based on linked list")},
                {new Provider(ArrayBasedQueue::new, "based on resizable array")}
        });
    }

    @Test
    public void test() {
        final Queue<String> queue = builder.build();

        queue.enqueue("5");
        assertSizeAndEmptyFlag(queue, 1);
        assertEquals(queue.dequeue(), "5");
        assertSizeAndEmptyFlag(queue, 0);

        queue.enqueue("4");
        assertSizeAndEmptyFlag(queue, 1);
        queue.enqueue("3");
        assertSizeAndEmptyFlag(queue, 2);
        assertEquals(queue.dequeue(), "4");
        assertSizeAndEmptyFlag(queue, 1);
        assertEquals(queue.dequeue(), "3");
        assertSizeAndEmptyFlag(queue, 0);

        queue.enqueue("2");
        queue.enqueue("6");
        queue.enqueue("7");
        queue.enqueue("8");
        queue.enqueue("9");
        queue.enqueue("10");
        assertSizeAndEmptyFlag(queue, 6);
        assertEquals(queue.dequeue(), "2");
        assertEquals(queue.dequeue(), "6");
        assertEquals(queue.dequeue(), "7");
        assertEquals(queue.dequeue(), "8");
        assertEquals(queue.dequeue(), "9");
        assertEquals(queue.dequeue(), "10");
        assertSizeAndEmptyFlag(queue, 0);

        queue.enqueue("1");
        assertSizeAndEmptyFlag(queue, 1);
        assertEquals(queue.dequeue(), "1");
        assertSizeAndEmptyFlag(queue, 0);
    }

    @Test
    public void iterator() {
        final Queue<String> queue = builder.build();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");

        Iterator<String> i = queue.iterator();
        assertTrue(i.hasNext());
        assertEquals(i.next(), "1");
        assertTrue(i.hasNext());
        assertEquals(i.next(), "2");
        assertTrue(i.hasNext());
        assertEquals(i.next(), "3");
        assertFalse(i.hasNext());
    }

    private static void assertSizeAndEmptyFlag(final Queue queue, final int expectedSize) {
        assertEquals(queue.size(), expectedSize);
        assertEquals(queue.isEmpty(), expectedSize == 0);
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

        Queue<String> build();

    }

}
