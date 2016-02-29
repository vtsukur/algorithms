package org.vtsukur.algorithms.permutations;

/**
 * @author volodymyr.tsukur
 */
public class Permutations {

    public static void main(final String[] args) {
        String input = "abc";
        permutations(input);
    }

    private static void permutations(String input) {
        permutations("", input);
    }

    private static void permutations(String prefix, String input) {
        if (input.length() == 0) {
            System.out.println(prefix);
        }

        for (int i = 0; i < input.length(); ++i) {
            String head = input.substring(i, i + 1);
            permutations(prefix + head, input.substring(0, i) + input.substring(i + 1));
        }
    }

}
