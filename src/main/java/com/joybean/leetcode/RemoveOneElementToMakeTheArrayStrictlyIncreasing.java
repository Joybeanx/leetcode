package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/">Remove One Element
 * to Make the Array Strictly Increasing</a>
 *
 * @author Joybean
 */
public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {
    /**
     * Iterative(bottom-up) DP
     *
     * @param nums
     * @return
     */
    public static boolean canBeIncreasing1(int[] nums) {
        int lis = 0;
        //dp[i] stores the length of LIS that ends with nums[i]
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            lis = Math.max(dp[i], lis);
        }
        return nums.length - lis <= 1;
    }

    /**
     * <a href="https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/discuss/1299306/Two-Conditions">Straight forward</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static boolean canBeIncreasing2(int[] nums) {
        return false;
    }
}
