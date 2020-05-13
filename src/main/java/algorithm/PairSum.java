package algorithm;

import java.util.HashMap;
import java.util.Map;

public class PairSum {
    public static void main(String[] args) {


        int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        int expected_1 = 2;
        int output_1 = numberOfWays(arr_1, k_1);
        System.out.println(output_1);

        int[] arr_2 = {1, 5, 3, 3, 3, 3, 3, 3};
        int k_2 = 6;

        int output_2 = numberOfWays(arr_2, k_2);
        System.out.println(output_2);
    }

    static int numberOfWays(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : arr) {
            if (!map.containsKey(key)) {
                map.put(key, 0);
            }
            map.put(key, map.get(key) + 1);

        }

        for (int key : map.keySet()) {
            if (map.get(k - key) != null) {
                if (map.get(k - key) > 2) {
                    count += map.get(key) * 2;
                } else
                    count += map.get(key);
            }

        }

        return count / 2;
    }

}
