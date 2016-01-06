package org.vtsukur.algorithms.heap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author volodymyr.tsukur
 */
public class HeapTest {

    @Test
    public void addAndPop() {
        final Heap<Integer> heap = new Heap<>();
        heap.add(4);
        heap.add(4);
        heap.add(2);
        heap.add(9);
        heap.add(4);
        heap.add(12);
        heap.add(9);
        heap.add(11);
        heap.add(13);
        heap.add(7);
        heap.add(20);

        assertEquals(heap.popMinimum(), (Integer) 2);
        assertEquals(heap.popMinimum(), (Integer) 4);
        assertEquals(heap.popMinimum(), (Integer) 4);
        assertEquals(heap.popMinimum(), (Integer) 4);
        assertEquals(heap.popMinimum(), (Integer) 7);
        assertEquals(heap.popMinimum(), (Integer) 9);
        assertEquals(heap.popMinimum(), (Integer) 9);
        assertEquals(heap.popMinimum(), (Integer) 11);
        assertEquals(heap.popMinimum(), (Integer) 12);
        assertEquals(heap.popMinimum(), (Integer) 13);
        assertEquals(heap.popMinimum(), (Integer) 20);
    }

}
