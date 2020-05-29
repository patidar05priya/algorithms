package dynamicEasy;

public class SubArraySum {
    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
        int[] input = new int[]{-2, -1, 0, -10, 6};
        System.out.println(subArraySum.maxSubArray(input));
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
