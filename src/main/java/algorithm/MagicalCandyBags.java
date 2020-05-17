package algorithm;

import java.util.Collections;
import java.util.PriorityQueue;

public class MagicalCandyBags {

    public static void main(String[] args) {
        int n_1 = 9, k_1 = 3;
        int[] arr_1 = {19, 78, 76, 72, 48, 8, 24, 74, 29};
        int expected_1 = 14;
        int output_1 = maxCandies(arr_1, n_1, k_1);
        System.out.println(output_1);
    }


    static int maxCandies(int[] arr, int n, int k) {
        int totalCandy = 0;
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            max.add(arr[i]);
        }

        while(k>0){
            int candy = max.remove();
            totalCandy +=  candy;
            max.add(candy/2);
            k--;
        }


        return totalCandy;

    }
}
