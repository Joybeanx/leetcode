package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">Longest Increasing Subsequence</a>
 *
 * @author Joybean
 */
public class LongestIncreasingSubsequence {
    /**
     * DP with memo
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int max = 1;
        for (int n : dp) {
            max = Math.max(max, n);
        }
        return max;
    }

    /**
     * Binary search
     * TODO
     * @param nums
     * @return
     */
    public static int lengthOfLIS2(int[] nums) {
        return 0;
    }
}
