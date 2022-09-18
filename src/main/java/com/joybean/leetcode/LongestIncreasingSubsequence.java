package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">Longest Increasing Subsequence</a>
 *
 * @author Joybean
 */
public class LongestIncreasingSubsequence {
    /**
     * Iterative(bottom-up) DP
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        //dp[i] stores the length of LIS that ends with nums[i]
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    /**
     * Binary search
     * TODO
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS2(int[] nums) {
        return 0;
    }
}
