package org.vtsukur.algorithms.queue;

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
public class QueueOfStringsTest {

    private final QueueOfStrings queue;

    public QueueOfStringsTest(final QueueOfStrings queue) {
        this.queue = queue;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> implementations() {
        return Arrays.asList(new Object[][]{
                {new CustomLinkedListBasedQueueOfStrings()},
                {new LinkedListBasedQueueOfStrings()},
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

    private static void assertSizeAndEmptyFlag(final QueueOfStrings queue, final int expectedSize) {
        assertEquals(queue.size(), expectedSize);
        assertEquals(queue.isEmpty(), expectedSize == 0);
    }

}
