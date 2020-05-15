package algorithm;

public class MinimumLengthSubstrings {
    public static void main(String[] args) {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
       int output_1 = minLengthSubstring(s_1, t_1);
        System.out.println(output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        System.out.println(output_2);
    }

    /**
     * @param s String
     * @param t String
     * @return int
     */
    static int minLengthSubstring(String s, String t) {
        StringBuilder subString = new StringBuilder();
        int L = t.length();
        int S = s.length();

        for (int i = 0; i < S; i++) {
            if (i == S - 1 && L < 0) {
                return -1;
            }
            if (t.contains(String.valueOf(s.charAt(i)))) {
                subString.append((s.charAt(i)));
                t = t.replaceFirst(String.valueOf(s.charAt(i)), "");
            } else if (subString.length() > 0) {
                subString.append((s.charAt(i)));
            }
            if (t.isEmpty()) {
                break;
            }
            L--;

        }
        return subString.length();

    }
}
