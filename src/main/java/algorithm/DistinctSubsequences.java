package algorithm;

import java.util.*;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String S = "rabbbit";
        String T = "rabbit";
        System.out.println(numDistinct(S, T));
    }

    static public int numDistinct(String s, String t) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.get(s.charAt(i)).add(i);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(s.charAt(i), set);
            }
        }

        int[] table = new int[s.length()];
        System.out.println(Arrays.toString(table));
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            boolean combinationPossible = map.get(t.charAt(i)).size() > 1;
            if (combinationPossible) {

            } else {

            }

        }

        System.out.println(map);

        return 0;

    }
}
