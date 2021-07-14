package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/minimum-path-sum/">Minimum Path Sum</a>
 *
 * @author Joybean
 */
public class MinimumPathSum {
    /**
     * Iterative(bottom-up) DP
     *
     * @param grid
     * @return
     */
    public static int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j];
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i - 1 >= 0 || j - 1 >= 0) {
                    dp[i][j] += i - 1 < 0 ? dp[i][j - 1] : dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * Recursive(top-down) DP
     * TODO
     *
     * @param grid
     * @return
     */
    public static int minPathSum2(int[][] grid) {
        return 0;
    }
}
