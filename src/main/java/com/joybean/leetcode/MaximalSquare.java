package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/maximal-square/">Maximal Square</a>
 *
 * @author Joybean
 */
public class MaximalSquare {
    /**
     * Iterative(bottom-up) DP
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare1(char[][] matrix) {
        int m = matrix.length + 1;
        int n = matrix[0].length + 1;
        //dp[i,j] represents the side length of the maximum square whose bottom right corner is the cell with index
        // (i-1,j-1) in the original matrix
        //Making dp[i][j] represents state of matrix[i-1][j-1] could save the trouble of boundary initialization
        int[][] dp = new int[m][n];
        int maxSideLen = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSideLen = Math.max(maxSideLen, dp[i][j]);
                }
            }
        }
        return maxSideLen * maxSideLen;
    }

    /**
     * Iterative(bottom-up) DP with state compression
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare2(char[][] matrix) {
        int m = matrix.length + 1;
        int n = matrix[0].length + 1;
        int[] dp = new int[n];
        int maxSideLen = 0;
        int pre = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int cur = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), pre) + 1;
                    maxSideLen = Math.max(maxSideLen, dp[j]);
                //Need set to 0 for getting the right dp[j] in next row calculation
                } else {
                    dp[j] = 0;
                }
                pre = cur;
            }
        }
        return maxSideLen * maxSideLen;
    }
}
