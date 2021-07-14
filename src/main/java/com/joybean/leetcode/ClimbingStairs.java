package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/">Climbing Stairs</a>
 *
 * @author Joybean
 */
public class ClimbingStairs {
    /**
     * Iterative(bottom-up) DP
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Iterative(bottom-up) DP with state compression
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        int prev = 1;
        int prev2 = 1;
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = prev + prev2;
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }

    /**
     * Recursive(top-down) DP with memo
     *
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        int memo[] = new int[n + 1];
        return climbStairs(0, n, memo);
    }

    public static int climbStairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n, memo);
        return memo[i];
    }
}
