package org.vtsukur.algorithms.symbol_table;

import java.util.Arrays;

/**
 * @author volodymyr.tsukur
 */
public final class OrderedArraySymbolTable<K extends Comparable<K>, V> extends BaseSymbolTable<K, V> {

    private K[] keys;

    private V[] values;

    private int size;

    public OrderedArraySymbolTable() {
        initStores();
    }

    @Override
    public void put(final K key, final V value) {
        assertKey(key);

        final int index = binarySearch(key);
        if (value != null) {
            updateOrInsert(key, index, value);
        } else {
            doDelete(key, index);
        }
    }

    private void updateOrInsert(final K key, final int index, final V value) {
        if (isKeyFound(key, index)) {
            values[index] = value;
        } else {
            ensureCapacity();

            int k = index;
            while (k < size && key.compareTo(keys[k]) > 0) {
                ++k;
            }

            for (int i = size; i > k; --i) {
                keys[i] = keys[i - 1];
                values[i] = values[i - 1];
            }
            keys[k] = key;
            values[k] = value;

            ++size;
        }
    }

    private void doDelete(final K key, final int index) {
        if (isKeyFound(key, index)) {
            final int last = size - 1;
            for (int i = index; i < last; ++i) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }
            keys[last] = null;
            values[last] = null;

            --size;

            shrinkToAvoidAbuse();
        }
    }

    @Override
    public V get(final K key) {
        assertKey(key);

        final int index = binarySearch(key);
        if (index != -1) {
            return values[index];
        } else {
            return null;
        }
    }

    private boolean isKeyFound(final K key, final int index) {
        return index < size && key.compareTo(keys[index]) == 0;
    }

    private int binarySearch(final K key) {
        if (isEmpty()) {
            return 0;
        }

        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;

            final int comparison = key.compareTo(keys[m]);
            if (comparison < 0) {
                hi = m - 1;
            } else if (comparison > 0) {
                lo = m + 1;
            } else {
                return m;
            }
        }

        return Math.min(lo, hi);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        initStores();
        size = 0;
    }

    private void initStores() {
        //noinspection unchecked
        keys = (K[]) new Comparable[1];
        //noinspection unchecked
        values = (V[]) new Object[1];
    }

    private void ensureCapacity() {
        if (keys.length == size) {
            reallocateStores(size * 2);
        }
    }

    private void shrinkToAvoidAbuse() {
        if (keys.length == size / 4) {
            reallocateStores(size / 2);
        }
    }

    private void reallocateStores(final int size) {
        keys = Arrays.copyOf(keys, size);
        values = Arrays.copyOf(values, size);
    }

}
