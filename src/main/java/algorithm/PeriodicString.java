package algorithm;

import java.util.Arrays;

/**
 * Find whether string S is periodic.
 * Periodic indicates S = nP.
 * e.g.
 * S = "ababab", then n = 3, and P = "ab"
 * S = "xxxxxx", then n = 1, and P = "x"
 * S = "aabbaaabba", then n = 2, and P = "aabba"
 * follow up:
 * Given string S, find out the P (repetitive pattern) of S.
 * //Solution to question O(n)
 */
public class PeriodicString {
    public static void main(String[] args) {
        String input = "acbabacb";

        int[] lps = new int[input.length()];
        computerLps(input, lps);
        System.out.println(Arrays.toString(lps));
        System.out.println(repeatedSubstringPattern(input));
    }


    static boolean repeatedSubstringPattern(String input) {
        int length = input.length();
        int[] lps = new int[input.length()];
        computerLps(input, lps);
        int len = lps[length - 1];
        if (len == 0) {
            return false;
        }

        return length % (length - len) == 0;
    }


    private static void computerLps(String toString, int[] lps) {
        lps[0] = 0;
        int i = 1;
        int len = 0;
        while (i < toString.length()) {
            if (toString.charAt(i) == toString.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }

    }
}
