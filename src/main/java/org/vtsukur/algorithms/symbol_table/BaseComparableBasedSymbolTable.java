package org.vtsukur.algorithms.symbol_table;

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

}
