package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Best Time to Buy and Sell Stock</a>
 *
 * @author Joybean
 */
public class BestTimeToBuyAndSellStock {
    /**
     * iterative(bottom-up) DP using two-dimensional array
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int dp[][] = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], 0);
    }

    /**
     * iterative(bottom-up) DP using one-dimensional array
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int dp[] = new int[prices.length];
        dp[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return dp[prices.length - 1];
    }

    /**
     * iterative(bottom-up) DP with state compression
     *
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        int ans = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return ans;
    }

    /**
     * Better performance
     *
     * @param prices
     * @return
     */
    public static int maxProfit4(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > ans) {
                ans = prices[i] - minprice;
            }
        }
        return ans;
    }
}
