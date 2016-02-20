package org.vtsukur.algorithms.binary;

import org.vtsukur.algorithms.stack.ArrayBasedStack;
import org.vtsukur.algorithms.stack.Stack;

import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.joining;

/**
 * @author volodymyr.tsukur
 */
public final class BinaryString {

    public static String of(final int number) {
        if (number == 0) {
            return "0";
        }

        final Stack<Character> stack = new ArrayBasedStack<>();
        int d = number;
        while (d > 0) {
            stack.push(d % 2 == 0 ? '0' : '1');
            d = d / 2;
        }
        return StreamSupport.stream(stack.spliterator(), false).map(Object::toString).collect(joining(""));
    }

}
