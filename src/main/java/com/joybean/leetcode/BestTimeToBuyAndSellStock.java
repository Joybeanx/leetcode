package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Best Time to Buy and Sell Stock</a>
 *
 * @author Joybean
 */
public class BestTimeToBuyAndSellStock {
    /**
     * Iterative(bottom-up) DP using two-dimensional array
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
     * Iterative(bottom-up) DP using one-dimensional array
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        //dp[i] represents max profit can achieve on the ith day
        int dp[] = new int[prices.length];
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return dp[prices.length - 1];
    }

    /**
     * Iterative(bottom-up) DP with state compression
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
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                ans = Math.max(price - minPrice, ans);
            }
        }
        return ans;
    }

    /**
     * Kadane's algorithm
     *
     * @param prices
     * @return
     * @see MaximumSubarray
     */
    public static int maxProfit5(int[] prices) {
        int n = prices.length;
        int[] profits = new int[n];
        profits[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            profits[i] = prices[i] - prices[i - 1];
        }
        int ans = 0;
        int maxSoFar = 0;
        for (int profit : profits) {
            maxSoFar = Math.max(profit, maxSoFar + profit);
            ans = Math.max(maxSoFar, ans);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solutions/39038/kadane-s-algorithm
     * -since-no-one-has-mentioned-about-this-so-far-in-case-if-interviewer-twists-the-input/">Kadane's algorithm</a>
     *
     * @param prices
     * @return
     * @see MaximumSubarray
     */
    public static int maxProfit6(int[] prices) {
        int ans = 0;
        int maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxSoFar = Math.max(prices[i] - prices[i - 1], maxSoFar + prices[i] - prices[i - 1]);
            ans = Math.max(maxSoFar, ans);
        }
        return ans;
    }


}
