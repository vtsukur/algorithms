package org.vtsukur.algorithms.symbol_table;

/**
 * @author volodymyr.tsukur
 */
public interface SymbolTable<K, V> {

    void put(K key, V value);

    V get(K key);

    boolean contains(K key);

    void delete(K key);

    boolean isEmpty();

    int size();

    void clear();

}
