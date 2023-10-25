package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/ugly-number-ii/">Ugly Number II</a>
 *
 * @author Joybean
 */
public class UglyNumberII {
    /**
     * <a href="https://leetcode.com/problems/ugly-number-ii/solutions/69364/my-16ms-c-dp-solution-with-short-explanation/">Iterative(bottom-up) DP + Three pointers</a>
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber1(int n) {
        //In order to produce a new smallest ugly number, one of (or some of) 2, 3, 5 needs to multiply a smaller
        // ugly number, and there come three pointers.
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(2 * dp[i2], Math.min(3 * dp[i3], 5 * dp[i5]));
            if (dp[i] == 2 * dp[i2]) {
                i2++;
            }
            if (dp[i] == 3 * dp[i3]) {
                i3++;
            }
            if (dp[i] == 5 * dp[i5]) {
                i5++;
            }
        }
        return dp[n - 1];
    }
}
