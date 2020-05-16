package algorithm;

import javafx.util.Pair;

import java.util.*;

/**
 * Given a list of the available denominations, determine if it's possible to receive exact change for an amount of
 * money targetMoney. Both the denominations and target amount will be given in generic units of that currency.
 */
public class ForeignCurrency {
    static int priya = 1;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int target_2 = 7;
        int arr_2[] = {2, 4, 10};
        boolean output_1 = canGetExactChange(target_2, arr_2);
        System.out.println(output_1);
    }

    private static boolean canGetExactChange(int target, int[] arr) {

        int length = arr.length;

        int[] table = new int[target+1];
        Arrays.fill(table, 0);
        table[0] = 1;

        for (int i = 0; i < length; i++) {
            for (int j = arr[i]; j <= target; j++) {
                table[j] += table[j - arr[i]];
            }
        }

        return table[target] > 0;
    }


}
