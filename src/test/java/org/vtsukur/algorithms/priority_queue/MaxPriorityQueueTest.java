package org.vtsukur.algorithms.priority_queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author volodymyr.tsukur
 */
public class MaxPriorityQueueTest {

    @Test
    public void test() {
        final MaxPriorityQueue<Integer> queue = new MaxPriorityQueueImpl<>();

        queue.add(1);
        assertEquals(queue.peekMax(), Integer.valueOf(1));

        queue.add(5);
        assertEquals(queue.peekMax(), Integer.valueOf(5));

        queue.add(3);
        assertEquals(queue.peekMax(), Integer.valueOf(5));

//        assertEquals(queue.pollMax(), Integer.valueOf(5));
//        assertEquals(queue.peekMax(), Integer.valueOf(3));
//
//        assertEquals(queue.pollMax(), Integer.valueOf(3));
//        assertEquals(queue.peekMax(), Integer.valueOf(1));
//
//        queue.add(10);
//        assertEquals(queue.peekMax(), Integer.valueOf(10));
//
//        queue.add(0);
//        assertEquals(queue.peekMax(), Integer.valueOf(10));
//
//        queue.add(-1);
//        assertEquals(queue.peekMax(), Integer.valueOf(10));
//
//        assertEquals(queue.pollMax(), Integer.valueOf(10));
//        assertEquals(queue.peekMax(), Integer.valueOf(1));
//        assertEquals(queue.pollMax(), Integer.valueOf(1));
    }

}
