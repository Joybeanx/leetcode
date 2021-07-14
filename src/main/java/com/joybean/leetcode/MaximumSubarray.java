package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/">Maximum Subarray</a>
 *
 * @author Joybean
 */
public class MaximumSubarray {
    /**
     * iterative(bottom-up) DP
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }

    /**
     * more cleaner iterative(bottom-up) DP
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int ans = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    /**
     * iterative(bottom-up) DP with state compression
     *
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {
        int ans = nums[0];
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(prev + nums[i], nums[i]);
            ans = Math.max(cur, ans);
            prev = cur;
        }
        return ans;
    }
}
