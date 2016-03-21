package org.vtsukur.algorithms.priority_queue;

import org.vtsukur.algorithms.util.StringUtils;

/**
 * @author volodymyr.tsukur
 */
public abstract class BaseMaxPriorityQueue<K extends Comparable<K>> implements MaxPriorityQueue<K> {

    @Override
    public String toString() {
        return StringUtils.humanizeClassNameLowerCase(getClass());
    }

}
