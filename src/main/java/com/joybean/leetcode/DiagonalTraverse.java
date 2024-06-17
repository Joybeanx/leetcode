package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/diagonal-traverse/">Diagonal Traverse</a>
 *
 * @author Joybean
 */
public class DiagonalTraverse {
    /**
     * <a href="https://leetcode.com/problems/diagonal-traverse/solutions/97711/java-15-lines-without-using-boolean
     * /">Change direction</a>
     *
     * @param mat
     * @return
     */
    public static int[] findDiagonalOrder1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int row = 0;
        int col = 0;
        int k = 0;
        while (row < m && col < n) {
            ans[k++] = mat[row][col];
            //The direction is always up when the sum of row & col is even
            if ((row + col) % 2 == 0) {
                // For last column, go down
                if (col == n - 1) {
                    row++;
                    // For first row & non-last columns, go right
                } else if (row == 0) {
                    col++;
                    // For not first row & non-last columns, go up and to the right
                } else {
                    row--;
                    col++;
                }
                // The direction is always down when the sum of row & col is odd
            } else {
                // For last row, go right
                if (row == m - 1) {
                    col++;
                    //  For non-last row & first column, go down
                } else if (col == 0) {
                    row++;
                    // For non-last row & non-first column, go down and to the left
                } else {
                    row++;
                    col--;
                }
            }
        }
        return ans;
    }
}
