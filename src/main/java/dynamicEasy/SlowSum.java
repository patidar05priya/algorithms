package dynamicEasy;

public class SlowSum {
    public static void main(String[] args) {
        int[] arr_2 = {7, 8, 1, 7, 8, 7};
        int expected_2 = 26;
        int output_2 = getTotalTime(arr_2);
        System.out.println(output_2);
    }

    static int getTotalTime(int[] arr) {
        int l = -1;
        int r = -1;


        for (int i = 1; i < arr.length; i++) {
            if (l == -1 || arr[i - 1] + arr[i] > arr[l] + arr[r]) {
                l = i - 1;
                r = i;
            }
        }

        int currentCount =arr[l]+arr[r];


        int worstPenalty = currentCount;

        l--;
        r++;


        while (l >= 0 || r < arr.length) {
            int left = l < 0 ? Integer.MIN_VALUE : arr[l];
            int right = r >= arr.length ? Integer.MIN_VALUE : arr[r];

            if (left > right) {
                currentCount += left;
                worstPenalty += currentCount;
                l--;
            } else {
                currentCount += right;
                worstPenalty += currentCount;
                r++;
            }


        }


        return worstPenalty;
    }

}
