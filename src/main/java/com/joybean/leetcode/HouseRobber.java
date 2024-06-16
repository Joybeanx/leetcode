package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/house-robber/">House Robber</a>
 *
 * @author Joybean
 */
public class HouseRobber {
    /**
     * Iterative(bottom-up) DP
     *
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }

    /**
     * Iterative(bottom-up) DP
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    /**
     * Iterative(bottom-up) DP with state compression
     *
     * @param nums
     * @return
     */
    public static int rob3(int[] nums) {
        int cur, prev1, prev2;
        cur = prev1 = prev2 = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            cur = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }


}
