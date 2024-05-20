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
        int n = nums.length;
        //dp[i] stores the length of LIS that ends with nums[i]
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
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
