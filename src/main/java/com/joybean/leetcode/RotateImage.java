package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/rotate-image/">Rotate Image</a>
 * Created by Joybean
 */
public class RotateImage {
    /**
     * Straight forward solution
     *
     * @param matrix
     */
    public static void rotate1(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];

            //When start to rotate item of the ith row, the first i items and the last (i+1) items has
            // been in the right position.
            int lenToSwap = row.length - i - 1;
            for (int j = i; j < lenToSwap; j++) {
                int value = row[j];
                //Swap until rotate back to (i,j) position
                swap(i, j, value, matrix, i, j);
            }
        }
    }

    private static void swap(int fromRowIdx, int fromColIdx, int fromVal, int[][] matrix, int startRowIdx,
        int startColIdx) {
        int toRowIdx = fromColIdx;
        int toColIdx = matrix.length - fromRowIdx - 1;
        int tmp = matrix[toRowIdx][toColIdx];
        matrix[toRowIdx][toColIdx] = fromVal;
        if (toRowIdx == startRowIdx && toColIdx == startColIdx) {
            return;
        }
        swap(toRowIdx, toColIdx, tmp, matrix, startRowIdx, startColIdx);
    }

    /**
     * <a href ="https://leetcode.com/problems/rotate-image/solutions/18872/a-common-method-to-rotate-the-image/">Flip
     * flip solution</a>
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     *
     * @param matrix
     */
    public static void rotate2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[m - i - 1];
            matrix[m - i - 1] = tmp;
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(i, j, matrix);
            }
        }
    }

    private static void swap(int i, int j, int[][] matrix) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
    }

}
