package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/counting-bits/">Counting Bits</a>
 *
 * @author Joybean
 */
public class CountingBits {
    /**
     * Iterative(bottom-up) DP
     *
     * @param n
     * @return
     */
    public static int[] countBits1(int n) {
        if (n == 0) {
            return new int[1];
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int half = i >> 1;
            //for even numbers, number of ones will be always the same as their halves
            if ((i & 1) == 0) {
                dp[i] = dp[half];
            //for old numbers, number of ones will be number of ones in their halves + 1
            } else {
                dp[i] = dp[half] + 1;
            }
        }
        return dp;
    }

    /**
     * Clean iterative(bottom-up) DP
     *
     * @param n
     * @return
     */
    public static int[] countBits2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
