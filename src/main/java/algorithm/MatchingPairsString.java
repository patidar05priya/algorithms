package algorithm;

import java.util.HashMap;
import java.util.Map;

public class MatchingPairsString {
    public static void main(String[] args) {
        String s_1 = "aaa";
        String t_1 = "cad";
        int output_1 = matchingPairs(s_1, t_1);

        System.out.println(output_1);
    }

    private static int matchingPairs(String s, String t) {
        int count = 0;
        if (s.equals(t)) {
            return s.length() - 2;
        }

        if(s.length()<=2){
            return 0;
        }
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                count++;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }

        }

        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            char value = map.get(entry.getKey());
            if (entry.getKey().equals(map.get(value))) {
                count = count + 2;
                break;
            }
        }

        return count;
    }
}
