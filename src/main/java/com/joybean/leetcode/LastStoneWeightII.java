package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/last-stone-weight-ii/">Last Stone Weight II</a>
 *
 * @author Joybean
 */
public class LastStoneWeightII {
    /**
     * Iterative(bottom-up) DP: 0/1 knapsack
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeightII1(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        //dp[i][j] represents the largest stone weight we can choose with capacity j from stones[0..i-1]
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (stones[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - stones[i - 1]] + stones[i - 1], dp[i][j]);
                }
            }
        }
        return sum - 2 * dp[n][target];
    }
}
