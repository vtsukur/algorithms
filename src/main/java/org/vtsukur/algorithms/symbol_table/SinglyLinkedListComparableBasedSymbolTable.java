package org.vtsukur.algorithms.symbol_table;

import org.apache.commons.lang3.tuple.Pair;

/**
 * @author volodymyr.tsukur
 */
public final class SinglyLinkedListComparableBasedSymbolTable<K extends Comparable<K>, V> extends BaseComparableBasedSymbolTable<K, V> {

    private Node<K, V> head;

    private int size;

    @Override
    public void put(final K key, final V value) {
        assertKey(key);

        if (value == null) {
            findAndDelete(key);
        } else {
            findAndUpdateOrInsert(key, value);
        }
    }

    private void findAndUpdateOrInsert(final K key, final V value) {
        final Node<K, V> target = find(key);
        if (target != null) {
            target.value = value;
        } else {
            head = new Node<>(key, value, head);

            ++size;
        }
    }

    private void findAndDelete(final K key) {
        final Pair<Node<K, V>, Node<K, V>> targetAndPrev = findWithPrev(key);

        final Node<K, V> target = targetAndPrev.getLeft();
        if (target != null) {
            final Node<K, V> prev = targetAndPrev.getRight();
            if (prev != null) {
                prev.next = target.next;
            }

            target.value = null;
            target.next = null;

            --size;
        }
    }

    @Override
    public V get(final K key) {
        final Node<K, V> node = find(key);
        return node != null ? node.value : null;
    }

    private Node<K, V> find(final K key) {
        return findWithPrev(key).getKey();
    }

    private Pair<Node<K, V>, Node<K, V>> findWithPrev(final K key) {
        Node<K, V> found = null;
        Node<K, V> prev = null;

        Node<K, V> i = head;
        while (i != null) {
            if (i.key.compareTo(key) == 0) {
                found = i;
                break;
            }
            prev = i;
            i = i.next;
        }

        return Pair.of(found, prev);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        // no GC optimizations here ;)
        head = null;
        size = 0;
    }

    /**
     * @author volodymyr.tsukur
     */
    private static class Node<K extends Comparable<K>, V> {

        final K key;

        V value;

        Node<K, V> next;

        Node(final K key, final V value, final Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

}
