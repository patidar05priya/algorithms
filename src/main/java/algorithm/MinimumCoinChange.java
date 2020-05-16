package algorithm;

import java.util.Arrays;

public class MinimumCoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 5, 6, 8};
        int amount = 9;

        System.out.println(coinChange(coins, amount));

    }

    private static int coinChange(int[] coins, int amount) {
        int[] tracker = new int[amount + 1];
        int[] R = new int[amount + 1];

        Arrays.sort(coins);
        Arrays.fill(tracker, Integer.MAX_VALUE - 1);
        Arrays.fill(R, -1);
        tracker[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    if (tracker[j - coins[i]] + 1 < tracker[j]) {
                        tracker[j] = 1 + tracker[j - coins[i]];
                        R[j] = i;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(R));
        printCoinCombination(R, coins);
        return tracker[amount] == Integer.MAX_VALUE - 1 ? -1 : tracker[amount];
    }


    private static void printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            return;
        }
        int start = R.length - 1;
        while (start != 0) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.println("");
    }

}



