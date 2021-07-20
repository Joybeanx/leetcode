package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/perfect-squares/">Perfect Squares</a>
 *
 * @author Joybean
 */
public class PerfectSquares {
    /**
     * Iterative(bottom-up) DP
     *
     * @param n
     * @return
     */
    public static int numSquares1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = n;
            for (int l = 1; l * l <= i; l++) {
                dp[i] = Math.min(dp[i], dp[i - l * l] + 1);
            }
        }
        return dp[n];
    }

    /**
     * BFS
     * TODO
     *
     * @param n
     * @return
     */
    public static int numSquares2(int n) {
        return 0;
    }
}
