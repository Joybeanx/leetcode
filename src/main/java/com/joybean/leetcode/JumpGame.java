package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/jump-game/">Jump Game</a>
 *
 * @author Joybean
 */
public class JumpGame {
    /**
     * DP using two-dimensional array:time Limit Exceeded
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
     * DP using one-dimensional array
     *
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
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
     * <a href="https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/">Greedy
     * algorithm</a>
     *
     * @param nums
     * @return
     */
    public static boolean canJump3(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
