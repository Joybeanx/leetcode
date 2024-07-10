package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/">Best Time to Buy
 * and Sell Stock with Cooldown</a>
 *
 * @author Joybean
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    /**
     * Iterative(bottom-up) DP
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][3];
        dp[1][1] = Integer.MIN_VALUE;
        for (int i = 2; i < dp.length; i++) {
            //rest without stock, can buy stock
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            //hold stock(just buy stock or rest with stock), can sell
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i - 2], dp[i - 1][1]);
            //sold stock, only can rest
            dp[i][2] = dp[i - 1][1] + prices[i - 2];
        }
        return Math.max(dp[n + 1][0], dp[n + 1][2]);
    }

    /**
     * Iterative(bottom-up) DP with state compression
     * TODO
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        return 0;
    }
}
