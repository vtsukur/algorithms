package org.vtsukur.algorithms.stack;

/**
 * @author volodymyr.tsukur
 */
public final class StackPushPopSequence {

    public static boolean isValid(final int[] sequence) {
        final Stack<Integer> stack = new ArrayBasedStack<>();

        int current = 0;
        int i = 0;
        while (i < sequence.length) {
            final int expected = sequence[i];
            if (current > expected) {
                if (stack.isEmpty() || stack.pop() != expected) {
                    return false;
                }
            } else {
                while (current < expected) {
                    stack.push(current++);
                }
                current++;
            }
            i++;
        }

        return true;
    }

}
