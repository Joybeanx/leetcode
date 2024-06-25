package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/maximal-square/">Maximal Square</a>
 *
 * @author Joybean
 */
public class MaximalSquare {
    /**
     * Straight forward iterative(bottom-up) DP
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare1(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //dp[i,j] represents the side length of the maximum square whose top right corner is the cell with index
        // (i-1,j-1) in the original matrix
        int dp[][] = new int[m + 1][n + 1];
        int maxLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1;
                    if (dp[i][j - 1] > 0) {
                        dp[i][j] = calcMaxSideLen(dp[i][j - 1] + 1, i - 1, j - 1, matrix);
                    }
                    maxLen = Math.max(dp[i][j], maxLen);
                }
            }

        }
        return maxLen * maxLen;
    }

    private static int calcMaxSideLen(int k, int startRow, int startCol, char[][] matrix) {
        for (int i = 0; i < k; i++) {
            if (startRow + i == matrix.length) {
                return i - 1;
            }
            if (matrix[startRow + i][startCol] == '0') {
                return i;
            }
        }
        for (int j = 0; j < k; j++) {
            if (matrix[startRow + k - 1][startCol - j] == '0') {
                return j;
            }
        }
        return k;
    }

    /**
     * Iterative(bottom-up) DP: calculate max side length by surrounding squares
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare2(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //dp[i,j] represents the side length of the maximum square whose bottom right corner is the cell with index
        // (i,j) in the original matrix
        int[][] dp = new int[m][n];
        int maxSideLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    if (i >= 1 && j >= 1) {
                        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    }
                    maxSideLen = Math.max(dp[i][j], maxSideLen);
                }
            }
        }
        return maxSideLen * maxSideLen;
    }

    /**
     * <a href="https://leetcode.com/problems/maximal-square/solutions/600149/python-thinking-process-diagrams-dp
     * -approach/">Iterative(bottom-up) DP: calculate max side length by surrounding squares</a>
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare3(char[][] matrix) {
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
                    //max side length depends on all squares surrounding current square
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
    public static int maximalSquare4(char[][] matrix) {
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
