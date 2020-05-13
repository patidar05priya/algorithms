package algorithm;

import java.util.HashMap;
import java.util.Map;

public class ReverseTOMakeEqual {

    public static void main(String[] args) {
        int[] array_a_1 = {1, 2, 3, 4};
        int[] array_b_1 = {1, 4, 3, 3};

        System.out.println(areTheyEqual(array_a_1, array_b_1));
    }

    static boolean areTheyEqual(int[] array_a, int[] array_b) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int a : array_a) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        for (int b : array_b) {
            if (!map.containsKey(b)) {
                return false;
            }
            if (map.get(b) == 1) {
                map.remove(b);
            } else {
                map.put(b, map.get(b) - 1);
            }
        }


        return map.size() == 0;
    }



}

