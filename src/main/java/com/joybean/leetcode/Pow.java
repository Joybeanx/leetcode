package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/powx-n/">Pow(x, n)</a>
 *
 * @author Joybean
 */
public class Pow {
    /**
     * Straight forward: Time Limit Exceeded
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow1(double x, int n) {
        if (x == 0d) {
            return 0;
        }
        double ans = 1d;

        for (long i = 0; i < Math.abs((long) n); i++) {
            ans *= x;
        }
        if (n < 0) {
            return 1 / ans;
        }
        return ans;

    }

    /**
     * Recursive solution
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow2(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n == 0) {
            return 1;
        }
        double ans = myPow2(x, n / 2);
        ans *= ans;
        if ((n & 1) == 1) {
            ans = ans * (n < 0 ? (1 / x) : x);
        }
        return ans;
    }
}
