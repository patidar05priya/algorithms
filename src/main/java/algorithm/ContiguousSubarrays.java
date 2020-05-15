package algorithm;

import java.util.Arrays;
import java.util.Stack;

public class ContiguousSubarrays {

    public static void main(String[] args) {

        int[] test_2 = {36, 91, 87, 79, 85, 59, 24, 67, 22, 19, 1, 15, 80, 95, 3, 6, 16, 82, 55, 66, 16, 47, 55, 59,
                7, 73, 64, 97, 54, 10, 16, 53, 70, 33, 2, 62, 46, 88, 19, 36, 62, 92, 22, 77, 87, 5, 74, 36, 28, 1,
                61, 44, 80, 45, 1, 8, 89, 96, 83, 26, 24, 60, 10, 23, 37, 57, 28, 25, 100, 96, 59, 15, 35, 24, 80, 18,
                34, 93, 52, 100, 48, 36, 87, 79, 49, 92, 38, 25, 5, 49, 70, 38, 16, 42, 71, 48, 39, 8, 95, 95};
        int[] expected_2 = {1, 13, 11, 1, 10, 2, 1, 7, 4, 3, 1, 2, 8, 27, 1, 2, 3, 13, 1, 7, 1, 2, 3, 5, 1, 9, 1, 68,
                4, 1, 2, 3, 9, 2, 1, 4, 1, 13, 1, 2, 3, 29, 1, 2, 14, 1, 7, 3, 2, 1, 5, 1, 11, 3, 1, 2, 15, 40, 10, 2,
                1, 9, 1, 2, 3, 6, 2, 1, 79, 10, 4, 1, 3, 1, 7, 1, 2, 9, 1, 31, 2, 1, 5, 2, 1, 18, 3, 2, 1, 4, 8, 2, 1,
                3, 12, 3, 2, 1, 19, 1};
        int[] output_2 = countSubarraysImproved(test_2);

        System.out.println(Arrays.equals(expected_2, output_2));
    }

    static int[] countSubarraysImproved(int[] arr) {
        int length = arr.length;
        int[] resultL = new int[length];

        Arrays.fill(resultL, 1);
        Stack<Integer> stack = new Stack<>();

        // left to right
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty()) {
                if (arr[i] > arr[stack.peek()]) {
                    resultL[i] = resultL[i] + resultL[stack.pop()];
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        stack = new Stack<>();

        // right to left
        int[] resultR = new int[length];
        Arrays.fill(resultR, 0);
        for (int i = length - 1; i >= 0; i--) {

            while (!stack.isEmpty()) {
                if (arr[i] > arr[stack.peek()]) {
                    resultR[i] = resultR[i] + resultR[stack.pop()] + 1;

                } else {
                    break;
                }
            }
            stack.push(i);

        }


        // final result L+R
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = resultL[i] + resultR[i];
        }
        return result;
    }


}
