package org.vtsukur.algorithms.sorting;

import org.vtsukur.algorithms.util.StringUtils;

/**
 * @author volodymyr.tsukur
 */
public abstract class BaseSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public String toString() {
        return StringUtils.humanizeClassNameLowerCase(getClass());
    }

}
