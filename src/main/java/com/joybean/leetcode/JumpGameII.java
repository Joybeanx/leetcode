package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/jump-game-ii/">Jump Game II</a>
 *
 * @author Joybean
 */
public class JumpGameII {
    /**
     * DP
     *
     * @param nums
     * @return
     */
    public static int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[nums.length - 1];
    }

    /**
     * Greedy algorithm
     *
     * @param nums
     * @return
     */
    public static int jump2(int[] nums) {
        int jumps = 0;
        int end = 0;
        //The farthest point that all points in [0, end] can reach
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}
