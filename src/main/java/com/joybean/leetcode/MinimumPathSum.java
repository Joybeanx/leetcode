package com.joybean.leetcode;

import java.util.Arrays;

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
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 0; i <= m; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[1][1] = grid[0][0];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != 1 || j != 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }


    /**
     * Iterative(bottom-up) DP
     *
     * @param grid
     * @return
     */
    public static int minPathSum3(int[][] grid) {
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
     * <a href="https://leetcode.com/problems/minimum-path-sum/">Iterative(bottom-up) DP: initialize dp[0][j] and dp[i][0]</a>
     *
     * @param grid
     * @return
     */
    public static int minPathSum4(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
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
    public static int minPathSum5(int[][] grid) {
        return 0;
    }


}
