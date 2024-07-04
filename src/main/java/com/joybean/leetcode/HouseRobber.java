package com.joybean.leetcode;

import java.util.Arrays;

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
        //dp[i] represents maximum amount of money can rob from nums[0...i-1]
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    /**
     * Iterative(bottom-up) DP (Recommended)
     *
     * @param nums
     * @return
     */
    public static int rob3(int[] nums) {
        int n = nums.length;
        //dp[i] represents maximum amount of money can rob from nums[0...i-2]
        int[] dp = new int[n + 2];
        for (int i = 2; i < n + 2; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }
        return dp[n + 1];
    }

    /**
     * Iterative(bottom-up) DP with state compression
     *
     * @param nums
     * @return
     */
    public static int rob4(int[] nums) {
        int n = nums.length;
        int prev1 = 0;
        int prev2 = 0;
        int ans = 0;
        for (int i = 2; i < n + 2; i++) {
            int tmp = ans;
            ans = Math.max(prev2 + nums[i - 2], prev1);
            prev1 = ans;
            prev2 = tmp;
        }
        return ans;
    }

    /**
     * Recursive(top-down) DP with memo
     *
     * @param nums
     * @return
     */
    public static int rob5(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return rob5(n - 1, nums, memo);
    }

    private static int rob5(int toIdx, int[] nums, int[] memo) {
        if (toIdx < 0) {
            return 0;
        }
        //unnecessary exit point
        //if (toIdx == 0) {
        //    return nums[toIdx];
        //}
        if (memo[toIdx] != -1) {
            return memo[toIdx];
        }
        int ans = Math.max(rob5(toIdx - 1, nums, memo), nums[toIdx] + rob5(toIdx - 2, nums, memo));
        memo[toIdx] = ans;
        return ans;
    }

}
