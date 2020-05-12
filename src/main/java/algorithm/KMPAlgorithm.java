package algorithm;

import java.util.Arrays;

public class KMPAlgorithm {
    // Driver program to test above function
    public static void main(String args[]) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMPSearch(pat, txt);

    }


    static void KMPSearch(String pattern, String txt) {
        int m = pattern.length();
        int n = txt.length();

        int[] lps = new int[m];
        computeLPSArray(pattern, lps);

        int i = 0;
        int j = 0;
        while (i < n) {
            if (txt.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != txt.charAt(i)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }

            }

        }


    }

    /**
     * computeLPSArray
     *
     * @param pattern pattern
     * @param lps
     */
    static void computeLPSArray(String pattern, int[] lps) {
        lps[0] = 0;
        int i = 1;
        int len = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
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
