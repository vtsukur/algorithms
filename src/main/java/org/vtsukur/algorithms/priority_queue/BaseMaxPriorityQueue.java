package org.vtsukur.algorithms.priority_queue;

import org.vtsukur.algorithms.util.StringUtils;

import java.util.NoSuchElementException;

/**
 * @author volodymyr.tsukur
 */
public abstract class BaseMaxPriorityQueue<K extends Comparable<K>> implements MaxPriorityQueue<K> {

    @Override
    public String toString() {
        return StringUtils.humanizeClassNameLowerCase(getClass());
    }

    protected final void assertNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("priority queue is empty");
        }
    }

}
