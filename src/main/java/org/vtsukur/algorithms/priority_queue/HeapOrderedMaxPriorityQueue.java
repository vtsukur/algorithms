package org.vtsukur.algorithms.priority_queue;

import org.vtsukur.algorithms.util.ArrayUtils;
import org.vtsukur.algorithms.util.ComparableUtils;

import java.lang.reflect.Array;

/**
 * @author volodymyr.tsukur
 */
public final class HeapOrderedMaxPriorityQueue<K extends Comparable<K>> extends BaseMaxPriorityQueue<K> {

    private static final int INITIAL_CAPACITY = 1;

    private K[] store;

    private int cursor;

    public HeapOrderedMaxPriorityQueue() {
        createInitialStore();
    }

    private void createInitialStore() {
        store = createStore(INITIAL_CAPACITY);
        cursor = 0;
    }

    @Override
    public void add(final K key) {
        ensureEnoughCapacity(cursor + 1);
        store[cursor] = key;
        swim(cursor);
        cursor++;
    }

    @Override
    public K pollMax() {
        final K max = peekMax();

        final int lastElementIndex = cursor - 1;
        store[0] = store[lastElementIndex];
        store[lastElementIndex] = null;

        --cursor;
        sink(0);
        ensureCapacityNotOverused(cursor);

        return max;
    }

    private void swim(final int index) {
        int i = index;
        int parent;
        while (hasParent(i) && less(parent = parentIndex(i), i)) {
            swap(parent, i);
            i = parent;
        }
    }

    private void sink(final int index) {
        int i = index;
        int leftChildIndex = leftChildIndex(i);
        while (leftChildIndex < cursor) {
            final int rightChildIndex = rightChildIndex(index);
            final int greaterChildIndex;
            if (rightChildIndex < cursor) {
                greaterChildIndex = less(leftChildIndex, rightChildIndex)
                        ? rightChildIndex : leftChildIndex;
            } else {
                greaterChildIndex = leftChildIndex;
            }
            if (less(greaterChildIndex, i)) {
                break;
            }
            swap(index, greaterChildIndex);
            i = greaterChildIndex;
            leftChildIndex = leftChildIndex(i);
        }
    }

    private void ensureEnoughCapacity(final int required) {
        if (required == store.length) {
            reallocateStore(required, store.length * 2);
        }
    }

    private void ensureCapacityNotOverused(final int occupied) {
        if (occupied == store.length / 4) {
            reallocateStore(occupied, store.length / 2);
        }
    }

    private K[] createStore(final int capacity) {
        //noinspection unchecked
        return (K[]) Array.newInstance(Comparable.class, capacity);
    }

    private void reallocateStore(final int occupied, final int newCapacity) {
        final K[] newStore = createStore(newCapacity);
        System.arraycopy(store, 0, newStore, 0, occupied);
        store = newStore;
    }

    private boolean less(final int i, final int j) {
        return ComparableUtils.less(store[i], store[j]);
    }

    private void swap(final int i, final int j) {
        ArrayUtils.swap(store, i, j);
    }

    private static boolean hasParent(final int index) {
        return index != 0;
    }

    private static int leftChildIndex(final int index) {
        return (index << 1) + 1;
    }

    private static int rightChildIndex(final int index) {
        return (index + 1) << 1;
    }

    private static int parentIndex(final int index) {
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

}
