package algorithm;

import java.util.Arrays;

public class BalancedSplit {
    public static void main(String[] args) {
        int arr_2[] = {3, 6, 3, 4, 4};
        //int arr_2[] = {2, 1, 2, 5};
        //int arr_2[] = {1, 1};
        boolean expected_2 = false;
        boolean output_2 = balancedSplitExists(arr_2);
          System.out.println(output_2);
    }

    private static boolean balancedSplitExists(int[] arr) {
        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
        }


        int rSum = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            rSum += arr[i];

            leftSum -= arr[i];

            if(rSum == leftSum){
                return true;
            }
        }
        return false;

    }


}
