package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/partition-equal-subset-sum/">Partition Equal Subset Sum</a>
 *
 * @author Joybean
 */
public class PartitionEqualSubsetSum {
    /**
     * Iterative(bottom-up) DP
     *
     * @param nums
     * @return
     */
    public static boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int n = nums.length;
        int target = sum / 2;
        //dp[i][j] indicates whether it is possible to pick numbers from nums[0..i-1] so that their sum is equal to j
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            //should start from 1 rather than nums[i-1]
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j] || (j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]]);
            }
        }
        return dp[nums.length][target];
    }


    /*
    //wrong solution, previous updates on dp[j] will affect later dp[j - nums[i - 1]] calculation in the same row
    //case: nums=[1,2,5]
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[j] = dp[j] || (j - nums[i - 1] >= 0 && dp[j - nums[i - 1]]);
            }
        }
        return dp[target];
    }
    */
    /**
     * Iterative(bottom-up) DP with state compression
     *
     * @param nums
     * @return
     */
    public static boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= 1; j--) {
                dp[j] = dp[j] || (j - nums[i - 1] >= 0 && dp[j - nums[i - 1]]);
            }
        }
        return dp[target];
    }

}
