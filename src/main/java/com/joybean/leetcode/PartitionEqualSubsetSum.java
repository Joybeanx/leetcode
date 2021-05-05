package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/partition-equal-subset-sum/">Partition Equal Subset Sum</a>
 *
 * @author Joybean
 */
public class PartitionEqualSubsetSum {
    /**
     * DP
     * @param nums
     * @return
     */
    public static boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

    /**
     * DP with state compression
     * @param nums
     * @return
     */
    public static boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= 1; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j - nums[i - 1]] || dp[j];
                }
            }
        }
        return dp[target];
    }

}
