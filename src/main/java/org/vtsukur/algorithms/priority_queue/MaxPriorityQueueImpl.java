package org.vtsukur.algorithms.priority_queue;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import static org.vtsukur.algorithms.util.ArrayUtils.swap;
import static org.vtsukur.algorithms.util.ComparableUtils.less;

/**
 * @author volodymyr.tsukur
 */
public final class MaxPriorityQueueImpl<K extends Comparable<K>> implements MaxPriorityQueue<K> {

    private static final int INITIAL_CAPACITY = 8;

    private K[] store;

    private int cursor;

    public MaxPriorityQueueImpl() {
        initializeStore(INITIAL_CAPACITY);
    }

    private void initializeStore(final int capacity) {
        //noinspection unchecked
        store = (K[]) Array.newInstance(Comparable.class, capacity);
    }

    @Override
    public void add(final K key) {
        store[cursor] = key;
        heapify(cursor);
        cursor++;
    }

    private void heapify(final int initialIndex) {
        int index = initialIndex;
        while (hasParent(index) && less(store[parent(index)], store[index])) {
            swap(store, parent(index), index);
            index = parent(index);
        }
    }

    private boolean hasParent(final int index) {
        return index != 0;
    }

    private int parent(final int index) {
        return (index - 1) / 2;
    }

    @Override
    public K peekMax() {
        assertNotEmpty();
        return store[0];
    }

    @Override
    public boolean isEmpty() {
        return cursor == 0;
    }

    private void assertNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("priority queue is empty");
        }
    }

}
