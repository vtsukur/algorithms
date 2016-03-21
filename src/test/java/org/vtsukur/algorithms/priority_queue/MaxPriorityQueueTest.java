package org.vtsukur.algorithms.priority_queue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author volodymyr.tsukur
 */
@RunWith(Parameterized.class)
public class MaxPriorityQueueTest {

    private final MaxPriorityQueue<Integer> queue;

    public MaxPriorityQueueTest(final MaxPriorityQueue<Integer> queue) {
        this.queue = queue;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> strategies() {
        return Arrays.asList(new Object[][]{
                { new HeapBasedMaxPriorityQueue<>() },
                { new UnorderedMaxPriorityQueue<>() },
        });
    }

    @Before
    public void clear() {
        queue.clear();
    }

    @Test
    public void add_poll_peek() {
        queue.add(1);
        assertEquals(queue.peekMax(), Integer.valueOf(1));

        queue.add(5);
        assertEquals(queue.peekMax(), Integer.valueOf(5));

        queue.add(3);
        assertEquals(queue.peekMax(), Integer.valueOf(5));

        assertEquals(queue.pollMax(), Integer.valueOf(5));
        assertEquals(queue.peekMax(), Integer.valueOf(3));

        assertEquals(queue.pollMax(), Integer.valueOf(3));
        assertEquals(queue.peekMax(), Integer.valueOf(1));

        queue.add(10);
        assertEquals(queue.peekMax(), Integer.valueOf(10));

        queue.add(0);
        assertEquals(queue.peekMax(), Integer.valueOf(10));
    }

    @Test
    public void size_and_isEmpty() {
        assertTrue(queue.isEmpty());
        assertEquals(queue.size(), 0);

        queue.add(1);
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 1);

        queue.pollMax();
        assertTrue(queue.isEmpty());
        assertEquals(queue.size(), 0);
    }

}
