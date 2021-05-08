package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/target-sum/">Target Sum</a>
 *
 * @author Joybean
 */
public class TargetSum {
    /**
     * DP:two dimension array
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays1(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (((sum + target) & 1) != 0) {
            return 0;
        }
        target = (sum + target) / 2;
        //dp[i][j] presents ways that make the sum of nums[0...i-1] be j
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length ; i++) {
            //must from 0, case: [0,0,0,0,0,0,0,0,1], 1
            for (int j = 0; j <= target; j++) {
                int k = j - nums[i - 1];
                if (k >= 0) {
                    dp[i][j] = dp[i - 1][k] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

    /**
     * DP:state compression
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays2(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (((sum + target) & 1) != 0) {
            return 0;
        }
        target = (sum + target) / 2;
        //dp[j] presents ways that make the sum of nums be j
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                int k = j - nums[i - 1];
                if (k >= 0) {
                    dp[j] = dp[k] + dp[j];
                }
            }
        }
        return dp[target];
    }
}
