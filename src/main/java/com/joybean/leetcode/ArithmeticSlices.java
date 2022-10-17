package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/arithmetic-slices/">Arithmetic Slices</a>
 *
 * @author Joybean
 */
public class ArithmeticSlices {
    /**
     * Iterative(bottom-up) DP
     *
     * @param nums
     * @return
     */
    public static int numberOfArithmeticSlices1(int[] nums) {
        int ans = 0;
        if (nums.length < 3) {
            return ans;
        }
        //dp[i] represents (number of arithmetic slices,difference between any two consecutive elements) ends with
        // nums[i]
        int[][] dp = new int[nums.length][2];
        dp[1] = new int[]{0, nums[1] - nums[0]};
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == dp[i - 1][1]) {
                dp[i] = new int[]{dp[i - 1][0] + 1, dp[i - 1][1]};
            } else {
                dp[i] = new int[]{0, nums[i] - nums[i - 1]};
            }
            ans += dp[i][0];
        }
        return ans;
    }

    /**
     * Iterative(bottom-up) DP
     *
     * @param nums
     * @return
     */
    public static int numberOfArithmeticSlices2(int[] nums) {
        int ans = 0;
        //dp[i] represents number of arithmetic slices ends with nums[i]
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
            ans += dp[i];
        }
        return ans;
    }

    /**
     * Iterative(bottom-up) DP with state compression
     *
     * @param nums
     * @return
     */
    public static int numberOfArithmeticSlices3(int[] nums) {
        int ans = 0;
        int prev = 0;
        for (int i = 2; i < nums.length; i++) {
            int cur = 0;
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                cur = prev + 1;
                ans += cur;
            }
            prev = cur;
        }
        return ans;
    }
}
