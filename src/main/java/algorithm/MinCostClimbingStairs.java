package algorithm;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int[] costs = new int[]{10,20};
        int res = minCostClimbingStairs.minCostClimbingStairs(costs);
        System.out.println(res);
    }

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;

        if (length == 1) {
            return cost[0];
        }

        int[] dp = new int[length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2 ;i < length; i++) {
            dp[i] = Math.min(cost[i]+dp[i-1], cost[i]+dp[i-2]);


        }

        return  Math.min(dp[length-1],dp[length-2]);

    }
}
