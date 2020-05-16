package algorithm;

public class LongestIncreasingSubsequence {

    public static void main(String args[]) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of lis is " + lengthOfLIS(arr) + "\n");
    }

    static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = 1;
        }
        int i = 0;
        int j = 1;


        while (j < n) {
            while (i < j) {
                if (nums[i] < nums[j]) {
                    temp[j] = Math.max(temp[i] + 1, temp[j]);
                }
                i++;
            }

            i = 0;
            j++;

        }

        int max = Integer.MIN_VALUE;
        for (int k = 0; k < n; k++) {
            max = Math.max(max, temp[k]);

        }
        return max;
    }

}
