package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/constrained-subsequence-sum/">Constrained Subsequence Sum</a>
 *
 * @author joybean
 */
public class ConstrainedSubsequenceSum {
    /**
     * DP solution:TLE
     *
     * @param nums
     * @param k
     * @return
     */
    public static int constrainedSubsetSum1(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            int n = 1;
            while (n <= k && i >= n) {
                dp[i] = Math.max(dp[i], dp[i - n] + nums[i]);
                n++;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int n : dp) {
            max = Math.max(n, max);
        }
        return max;
    }
}
