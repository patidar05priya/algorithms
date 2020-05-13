package algorithm;

import java.util.Arrays;

public class ContiguousSubarrays {

    public static void main(String[] args) {

        int[] input = new int[]{3, 4, 1, 6, 2};
        int[] result = countSubarrays(input);
        System.out.println(Arrays.toString(result));

    }

    static int[] countSubarrays(int[] arr) {
        // Write your code here
        int length = arr.length;
        int[] result = new int[length];

        int current = 0;
        int forward;
        int backward;

        while (current < length) {
            forward = current + 1;
            backward = current - 1;
            int forwardCount = 0;
            int backwardCount = 0;

            if (forward < length) {
                forwardCount = findForWardArray(arr, current, forward);
            }
            if (backward >= 0) {
                backwardCount = findBackwardArray(arr, current, backward);
            }

            result[current] = forwardCount + backwardCount + 1;
            current++;
        }
        return result;



    }

    static int findBackwardArray(int[] arr, int current, int backward) {
        int count = 0;
        while (backward >= 0) {
            if (arr[current] > arr[backward]) {
                count++;
                backward--;
            } else {
                break;
            }
        }

        return count;
    }

    static int findForWardArray(int[] arr, int current, int forward) {
        int count = 0;
        while (forward < arr.length) {
            if (arr[current] > arr[forward]) {
                count++;
                forward++;
            } else {
                break;
            }
        }

        return count;
    }


}
