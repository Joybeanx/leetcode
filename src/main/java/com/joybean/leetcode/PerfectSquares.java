package com.joybean.leetcode;

import java.util.Arrays;

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
     * Recursive(top-down) DP with memo
     *
     * @param n
     * @return
     */
    public static int numSquares2(int n) {
        int[] memo = new int[10001];
        Arrays.fill(memo, -1);
        return numSquares2(n, memo);
    }
    private static int numSquares2(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }
        //if (n == 1) {
        //   return 1;
        //}
        if (memo[n] != -1) {
            return memo[n];
        }
        int ans = n;
        for (int i = 1; i * i <= n; i++) {
            ans = Math.min(numSquares2(n - i * i, memo) + 1, ans);
        }
        memo[n] = ans;
        return ans;
    }

    /**
     * BFS
     * TODO
     *
     * @param n
     * @return
     */
    public static int numSquares3(int n) {
        return 0;
    }
}
