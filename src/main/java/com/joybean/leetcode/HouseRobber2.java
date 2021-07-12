package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/house-robber-ii/">House Robber II</a>
 *
 * @author Joybean
 */
public class HouseRobber2 {
    /**
     * recursive(top-down) DP
     *
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robByRange(nums, 0, n - 2), robByRange(nums, 1, n - 1));
    }

    private static int robByRange(int[] nums, int start, int end) {
        int cur, prev1, prev2;
        cur = prev1 = prev2 = 0;
        for (int i = end; i >= start; i--) {
            cur = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }
}
