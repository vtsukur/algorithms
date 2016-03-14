package org.vtsukur.algorithms.shuffling;

import org.vtsukur.algorithms.util.StringUtils;

/**
 * @author volodymyr.tsukur
 */
abstract class BaseShuffle implements Shuffle {

    @Override
    public String toString() {
        return StringUtils.humanizeClassNameLowerCase(getClass());
    }

}
