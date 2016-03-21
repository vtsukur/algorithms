package org.vtsukur.algorithms.priority_queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author volodymyr.tsukur
 */
public class MaxPriorityQueueTest {

    @Test
    public void test() {
        final MaxPriorityQueue<Integer> queue = new MaxPriorityQueueImpl<>();

        assertTrue(queue.isEmpty());

        queue.add(1);
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 1);
        assertEquals(queue.peekMax(), Integer.valueOf(1));

        queue.add(5);
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 2);
        assertEquals(queue.peekMax(), Integer.valueOf(5));

        queue.add(3);
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 3);
        assertEquals(queue.peekMax(), Integer.valueOf(5));

        assertEquals(queue.pollMax(), Integer.valueOf(5));
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 2);
        assertEquals(queue.peekMax(), Integer.valueOf(3));

        assertEquals(queue.pollMax(), Integer.valueOf(3));
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 1);
        assertEquals(queue.peekMax(), Integer.valueOf(1));

        queue.add(10);
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 2);
        assertEquals(queue.peekMax(), Integer.valueOf(10));

        queue.add(0);
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 3);
        assertEquals(queue.peekMax(), Integer.valueOf(10));

        queue.add(-1);
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 4);
        assertEquals(queue.peekMax(), Integer.valueOf(10));

        assertEquals(queue.pollMax(), Integer.valueOf(10));
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 3);
        assertEquals(queue.peekMax(), Integer.valueOf(1));

        assertEquals(queue.pollMax(), Integer.valueOf(1));
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 2);
        assertEquals(queue.peekMax(), Integer.valueOf(0));
    }

}
