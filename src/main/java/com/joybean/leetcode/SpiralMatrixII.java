package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix-ii/">Spiral Matrix II</a>
 *
 * @author Joybean
 */
public class SpiralMatrixII {
    /**
     * Straight forward: use global row and col
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix1(int n) {
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int row = 0;
        int col = 0;
        int[][] ans = new int[n][n];
        int num = 1;
        while (num <= n * n) {
            for (col = colStart; col <= colEnd; col++) {
                ans[row][col] = num++;
            }
            rowStart++;
            //col must be greater than colEnd, we must reset to colEnd
            col--;
            for (row = rowStart; row <= rowEnd; row++) {
                ans[row][col] = num++;
            }
            colEnd--;
            //row must be greater than rowEnd, we must reset to rowEnd
            row--;
            for (col = colEnd; col >= colStart; col--) {
                ans[row][col] = num++;
            }
            rowEnd--;
            col++;
            for (row = rowEnd; row >= rowStart; row--) {
                ans[row][col] = num++;
            }
            colStart++;
            row++;
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/spiral-matrix-ii/solutions/22289/my-super-simple-solution-can-be-used-for-both-spiral-matrix-i-and-ii/">Concise solution</a>
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix2(int n) {
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int[][] ans = new int[n][n];
        int num = 1;
        while (num <= n * n) {
            for (int k = colStart; k <= colEnd; k++) {
                ans[rowStart][k] = num++;
            }
            rowStart++;
            for (int k = rowStart; k <= rowEnd; k++) {
                ans[k][colEnd] = num++;
            }
            colEnd--;
            for (int k = colEnd; k >= colStart; k--) {
                ans[rowEnd][k] = num++;
            }
            rowEnd--;
            for (int k = rowEnd; k >= rowStart; k--) {
                ans[k][colStart] = num++;
            }
            colStart++;
        }
        return ans;
    }
}
