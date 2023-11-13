package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/jump-game-v/">Jump Game V</a>
 *
 * @author Joybean
 */
public class JumpGameV {
    /**
     * <a href="https://leetcode.com/problems/climbing-stairs/discuss/963994/Java-from-Recursion-to-DP">Clean
     * recursive(top-down) DP with memo</a>
     *
     * @param arr
     * @param d
     * @return
     */
    public static int maxJumps1(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(maxJumps1(i, arr, d, dp), ans);
        }
        return ans;
    }

    private static int maxJumps1(int i, int[] arr, int d, int[] dp) {
        if (dp[i] != 0) {
            return dp[i];
        }
        int maxJumps = 1;
        for (int j = i + 1; j <= Math.min(i + d, arr.length - 1) && arr[i] > arr[j]; j++) {
            maxJumps = Math.max(1 + maxJumps1(j, arr, d, dp), maxJumps);
        }
        for (int j = i - 1; j >= Math.max(i - d, 0) && arr[i] > arr[j]; j--) {
            maxJumps = Math.max(1 + maxJumps1(j, arr, d, dp), maxJumps);
        }
        dp[i] = maxJumps;
        return dp[i];
    }
}
