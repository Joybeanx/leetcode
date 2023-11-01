package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iv/">Combination Sum IV</a>
 *
 * @author Joybean
 */
public class CombinationSumIV {
    /**
     * Iterative(bottom-up) DP
     *
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum1(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    /**
     * Recursive(top-down) DP with memo
     *
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum2(int[] nums, int target) {
        int[] memo = new int[target + 1];
        //TLE if use memo[target] != 0 to determine whether result has been calculated
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return combinationSumInternel(nums, target, memo);
    }

    private static int combinationSumInternel(int[] nums, int target, int[] memo) {
        if (memo[target] != -1) {
            return memo[target];
        }
        int ans = 0;
        for (int num : nums) {
            if (target >= num) {
                ans += combinationSumInternel(nums, target - num, memo);
            }
        }
        memo[target] = ans;
        return ans;
    }
}
