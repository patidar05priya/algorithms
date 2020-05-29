package algorithm;

import javafx.util.Pair;

import java.util.*;

public class ThreeSumZero {
    public static void main(String[] args) {
        int[] input = new int[]{-4, -1, -1, 0, 1, 2};
        Set<int[]> myList = getSum(input);

        for (int[] i : myList) {
            System.out.println(Arrays.toString(i));
        }
    }

    private static Set<int[]> getSum(int[] input) {
        Set<int[]> result = new HashSet<>();
        Arrays.sort(input);
        Map<Integer, Set<Pair<Integer, Integer>>> map = new HashMap<>();
        for (int i = 1; i < input.length; i++) {
            int twoSum = 0 - (input[i - 1] + input[i]);
            if (map.containsKey(twoSum)) {
                Set<Pair<Integer, Integer>> list = map.get(twoSum);
                list.add(new Pair<>(i - 1, i));
                map.put(twoSum, list);
            } else {
                Set<Pair<Integer, Integer>> list = new HashSet<>();
                list.add(new Pair<>(i - 1, i));
                map.put(twoSum, list);
            }

        }

        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                int[] res = new int[3];
                res[0] = i;
                Set<Pair<Integer, Integer>> list = map.get(input[i]);
                for (Pair<Integer, Integer> pair : list) {
                    res[1] = pair.getKey();
                    res[2] = pair.getValue();
                }

                Arrays.sort(res);
                System.out.println(Arrays.toString(res));
                System.out.println(result.contains(res));
                result.add(res);

            }

        }

        return result;
    }
}
