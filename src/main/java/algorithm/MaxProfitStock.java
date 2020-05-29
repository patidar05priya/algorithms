package algorithm;

public class MaxProfitStock {

    public static void main(String[] args) {
        MaxProfitStock maxProfitStock = new MaxProfitStock();
        int[] stocks = new int[]{7,6,4,3,1};
        int profit = maxProfitStock.maxProfit(stocks);
        System.out.println(profit);
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int[] dp = new int[prices.length];
        int profit = 0;
        dp[0] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(prices[i], dp[i - 1]);
            profit = Math.max(profit, prices[i] - dp[i]);
        }

        return profit;
    }
}
