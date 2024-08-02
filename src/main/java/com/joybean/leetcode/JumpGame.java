package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/jump-game/">Jump Game</a>
 *
 * @author Joybean
 */
public class JumpGame {
    /**
     * Iterative(bottom-up) DP using two-dimensional array:time Limit Exceeded
     *
     * @param nums
     * @return
     */
    public static boolean canJump1(int[] nums) {
        //dp[i][j] represents whether we can jump from i to j
        boolean[][] dp = new boolean[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j <= nums.length - 1; j++) {
                dp[i][j] = canJump(dp, nums, i, j);
            }
        }
        return dp[0][nums.length - 1];
    }

    private static boolean canJump(boolean[][] dp, int[] nums, int i, int j) {
        int cnt = 1;
        while (cnt <= nums[i]) {
            if (i + cnt < dp.length && dp[i + cnt][j]) {
                return true;
            }
            cnt++;
        }
        return false;
    }


    /**
     * Iterative(bottom-up) DP using one-dimensional array: calculate dp[i+k] based on dp[i]
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        //dp[i] represents whether we can jump from 0 to i
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                for (int j = 1; j <= nums[i] && i + j < n; j++) {
                    dp[i + j] = dp[i];
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * Iterative(bottom-up) DP using one-dimensional array: calculate dp[i] based on dp[i-k]
     *
     * @param nums
     * @return
     */
    public static boolean canJump3(int[] nums) {
        int n = nums.length;
        //dp[i] represents whether we can jump from 0 to i
        boolean[] dp = new boolean[n];
        // base case
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * <a href="https://leetcode.com/problems/jump-game/solutions/3758301/java-easy-solution-with-explanation/">Greedy
     * algorithm</a>
     *
     * @param nums
     * @return
     */
    public static boolean canJump4(int[] nums) {
        int n = nums.length;
        //keep track of the max reachable index
        int maxReachable = 0;
        for (int i = 0; i < n; ++i) {
            if (i > maxReachable) {
                return false;
            }
            maxReachable = Math.max(maxReachable, i + nums[i]);
            //below judgement is not necessary, however it can improve performance
            if (maxReachable >= n - 1) {
                return true;
            }
        }
        return true;
    }


    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReachable) {
                return false;
            }
            maxReachable = Math.max(i + nums[i], maxReachable);
        }
        return true;
    }
}
