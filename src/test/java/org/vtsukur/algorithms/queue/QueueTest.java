package org.vtsukur.algorithms.queue;

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
public class QueueTest {

    private final Queue<String> queue;

    public QueueTest(final Queue<String> queue) {
        this.queue = queue;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> implementations() {
        return Arrays.asList(new Object[][]{
                {new CustomLinkedListBasedQueue<String>()},
                {new LinkedListBasedQueue<String>()},
                {new ArrayBasedQueue<String>()}
        });
    }

    @Test
    public void test() {
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

        queue.enqueue("1");
        assertSizeAndEmptyFlag(queue, 1);
        assertEquals(queue.dequeue(), "1");
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
    }

    @Test
    public void iterator() {
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

}
