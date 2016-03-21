package org.vtsukur.algorithms.priority_queue;

import java.util.ArrayList;
import java.util.List;

import static org.vtsukur.algorithms.util.ComparableUtils.less;

/**
 * @author volodymyr.tsukur
 */
public final class UnorderedMaxPriorityQueue<K extends Comparable<K>> extends BaseMaxPriorityQueue<K> {

    private final List<K> store = new ArrayList<>();

    @Override
    public void add(final K key) {
        store.add(key);
    }

    @Override
    public K pollMax() {
        assertNotEmpty();

        final int maxIndex = findMaxIndex();
        return store.remove(maxIndex);
    }

    @Override
    public K peekMax() {
        assertNotEmpty();

        final int maxIndex = findMaxIndex();
        return store.get(maxIndex);
    }

    private int findMaxIndex() {
        int maxIndex = 0;
        K max = store.get(maxIndex);
        for (int i = 1; i < store.size(); ++i) {
            final K current = store.get(i);
            if (less(max, current)) {
                max = current;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    @Override
    public boolean isEmpty() {
        return store.isEmpty();
    }

    @Override
    public int size() {
        return store.size();
    }

    @Override
    public void clear() {
        store.clear();
    }

}
