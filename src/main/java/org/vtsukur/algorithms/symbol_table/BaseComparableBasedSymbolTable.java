package org.vtsukur.algorithms.symbol_table;

import org.vtsukur.algorithms.util.StringUtils;

import java.util.Objects;

/**
 * @author volodymyr.tsukur
 */
abstract class BaseComparableBasedSymbolTable<K extends Comparable<K>, V> implements ComparableBasedSymbolTable<K, V> {

    @Override
    public final boolean contains(final K key) {
        return get(key) != null;
    }

    @Override
    public final void delete(final K key) {
        put(key, null);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    protected final void assertKey(final K key) {
        Objects.requireNonNull(key, "key is null");
    }

    @Override
    public String toString() {
        return StringUtils.humanizeClassNameLowerCase(getClass());
    }

}
