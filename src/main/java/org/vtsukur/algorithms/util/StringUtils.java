package org.vtsukur.algorithms.util;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.*;

/**
 * @author volodymyr.tsukur
 */
public final class StringUtils {

    public static String humanizeClassNameLowerCase(final Class<?> clazz) {
        return humanizeLowerCase(clazz.getSimpleName());
    }

    private static String humanizeLowerCase(final String value) {
        return Stream.of(splitByCharacterTypeCamelCase(value))
                .map(String::toLowerCase)
                .collect(Collectors.joining(" "));
    }

}
