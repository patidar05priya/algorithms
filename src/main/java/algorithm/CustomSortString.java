package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class CustomSortString {
    public static void main(String[] args) {
        String[] strArr = {"ccc", "ca", "cb", "bc", "ba", "b", "ab", "cc", "a", "d", ""};
        char[] order = {'c', 'b', 'a'};
        System.out.println(Arrays.toString(strArr));
        sort(strArr, order);
    }


    private static boolean sort(String[] strArr, char[] order) {
        String orders = Arrays.toString(order);
        Comparator<String> myComp = (s1, s2) -> {

            if (s1.isEmpty() || s2.isEmpty()) {
                return -1;
            }
            for (int i = 0; i < Math.min(s1.length()
                    , s2.length()); i++) {

                int indexA = orders.indexOf(s1.charAt(i));
                int indexB = orders.indexOf(s2.charAt(i));

                // if indexes are same
                if (indexA == indexB) {

                    // if length is not equal, give priority to small string
                    if (i + 2 == Math.max(s1.length(), s2.length()) &&
                            s1.length() != s2.length()) {
                        return -1;
                    }
                    continue;
                } else if (indexA > indexB) {
                    return 1;
                } else if (indexA == -1) {
                    return 1;
                } else {
                    return -1;
                }

            }

            return 0;
        };

        Arrays.sort(strArr, myComp);
        System.out.println(Arrays.toString(strArr));
        return false;
    }
}
