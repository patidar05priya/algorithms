package algorithm;

import java.util.HashMap;
import java.util.Map;

public class LenghtOfLongestAP {
    public static void main(String[] args) {
        int set1[] = {44, 46, 22, 68, 45, 66, 43, 9, 37, 30, 50, 67, 32, 47, 44, 11, 15, 4, 11, 6, 20, 64, 54, 54, 61, 63, 23, 43, 3, 12, 51, 61, 16, 57, 14, 12, 55, 17, 18, 25, 19, 28, 45, 56, 29, 39, 52, 8, 1, 21, 17, 21, 23, 70, 51, 61, 21, 52, 25, 28};
        System.out.println(lengthOfLongestAP(set1));
    }

    private static int lengthOfLongestAP(int[] A) {
        int n = A.length;
        if (n <= 2) {
            return n;
        }

        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = A[i] - A[j];
                if (dp[j].containsKey(k)) {
                    if (dp[i].containsKey(k) && dp[i].get(k) > dp[j].get(k)) {
                        continue;
                    } else {

                        dp[i].put(k, dp[j].get(k) + 1);
                    }
                } else {
                    if (!dp[i].containsKey(k)) {
                        dp[i].put(k, 1);
                    }

                }

            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (Map.Entry<Integer, Integer> entry : dp[i].entrySet()) {
                max = Math.max(max, entry.getValue());

            }
        }
        return max + 1;

    }
}
