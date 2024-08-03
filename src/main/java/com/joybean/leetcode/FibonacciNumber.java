package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/fibonacci-number/">Fibonacci Number</a>
 *
 * @author Joybean
 */
public class FibonacciNumber {
    /**
     * Iterative(bottom-up) DP
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * <a href="https://leetcode.com/problems/fibonacci-number/solutions/215992/java-solutions/">Optimized iterative(bottom-up) DP</a>
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        //base case
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
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
    public static int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        int ans = 1;
        int prev1 = 1;
        int prev2 = 0;
        for (int i = 2; i <= n; i++) {
            int tmp = ans;
            ans = prev1 + prev2;
            prev1 = ans;
            prev2 = tmp;
        }
        return ans;
    }

    /**
     * Iterative(bottom-up) DP with state compression
     *
     * @param n
     * @return
     */
    public static int fib4(int n) {
        if (n == 0) {
            return 0;
        }
        int ans = 1;
        int prev1 = 1;
        int prev2 = 0;
        for (int i = 2; i <= n; i++) {
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/fibonacci-number/solutions/215992/java-solutions/">Optimized iterative(bottom-up) DP with state compression</a>
     *
     * @param n
     * @return
     */
    public static int fib5(int n) {
        //base case
        if (n < 2) {
            return n;
        }
        int ans = 0;
        int prev1 = 1;
        int prev2 = 0;
        for (int i = 2; i <= n; i++) {
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }

    /**
     * Recursive(top-down) DP with memo
     *
     * @param n
     * @return
     */
    public static int fib6(int n) {
        int[] memo = new int[31];
        return fib6(n, memo);
    }

    private static int fib6(int n, int[] memo) {
        if (n < 2) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = fib6(n - 1, memo) + fib6(n - 2, memo);
    }


    public static void main(String[] args) {
        fib2(4);
    }
}
