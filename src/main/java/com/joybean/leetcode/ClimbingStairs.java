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
     * <a href="https://leetcode.com/problems/climbing-stairs/discuss/963994/Java-from-Recursion-to-DP">Clean
     * recursive solution:Time Limit Exceeded</a>
     *
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs3(n - 1) + climbStairs3(n - 2);
    }

    /**
     * <a href="https://leetcode.com/problems/climbing-stairs/discuss/963994/Java-from-Recursion-to-DP">Clean
     * recursive(top-down) DP with memo</a>
     *
     * @param n
     * @return
     */
    public static int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int memo[] = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        return climbStairs(n, memo);
    }

    private static int climbStairs(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }
        int ways = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        memo[n] = ways;
        return ways;
    }

    /**
     * Recursive(top-down) DP with memo
     *
     * @param n
     * @return
     */
    public static int climbStairs5(int n) {
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
