package org.vtsukur.algorithms.priority_queue;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import static org.vtsukur.algorithms.util.ArrayUtils.swap;
import static org.vtsukur.algorithms.util.ComparableUtils.less;

/**
 * @author volodymyr.tsukur
 */
public final class HeapBasedMaxMaxPriorityQueue<K extends Comparable<K>> extends BaseMaxPriorityQueue<K> {

    private static final int INITIAL_CAPACITY = 1;

    private K[] store;

    private int cursor;

    public HeapBasedMaxMaxPriorityQueue() {
        createInitialStore();
    }

    private void createInitialStore() {
        store = createStore(INITIAL_CAPACITY);
        cursor = 0;
    }

    private K[] createStore(final int capacity) {
        //noinspection unchecked
        return (K[]) Array.newInstance(Comparable.class, capacity);
    }

    @Override
    public void add(final K key) {
        ensureCapacity(cursor + 1);
        store[cursor] = key;
        heapify(cursor);
        cursor++;
    }

    @Override
    public K pollMax() {
        final K max = peekMax();

        store[0] = null;
        int index = 0;
        int leftChildIndex = leftChildIndex(index);
        while (leftChildIndex < cursor) {
            final int rightChildIndex = rightChildIndex(index);
            final int nextIndex;
            if (rightChildIndex < cursor) {
                nextIndex = less(store[leftChildIndex], store[rightChildIndex])
                        ? rightChildIndex : leftChildIndex;
            } else {
                nextIndex = leftChildIndex;
            }
            swap(store, index, nextIndex);
            index = nextIndex;
            leftChildIndex = leftChildIndex(index);
        }
        if (index < cursor - 1) {
            store[index] = store[cursor - 1];
            heapify(index);
        }

        cursor--;

        return max;
    }

    private void heapify(final int index) {
        int i = index;
        while (hasParent(i) && less(store[parent(i)], store[i])) {
            swap(store, parent(i), i);
            i = parent(i);
        }
    }

    private int leftChildIndex(final int index) {
        return (index << 1) + 1;
    }

    private int rightChildIndex(final int index) {
        return (index + 1) << 1;
    }

    private void ensureCapacity(final int newCapacity) {
        if (newCapacity == store.length) {
            final K[] newStore = createStore(store.length * 2);
            System.arraycopy(store, 0, newStore, 0, store.length);
            store = newStore;
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

    @Override
    public int size() {
        return cursor;
    }

    @Override
    public void clear() {
        createInitialStore();
    }

    private void assertNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("priority queue is empty");
        }
    }

}
