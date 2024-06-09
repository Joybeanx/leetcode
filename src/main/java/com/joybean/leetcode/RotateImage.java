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
     * <a href ="https://leetcode.com/problems/rotate-image/solutions/18872/a-common-method-to-rotate-the-image/">Flip flip solution</a>
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     *
     * @param matrix
     */
    public static void rotate2(int[][] matrix) {
        int m = matrix.length;
        int top = 0;
        int bottom = m - 1;
        //reverse up to down
        while (top < bottom) {
            int[] tmp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = tmp;
            top++;
            bottom--;
        }
        //swap the symmetry
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                swap(i, j, j, i, matrix);
            }
        }
    }

    private static void swap(int r1, int c1, int r2, int c2, int[][] matrix) {
        int tmp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = tmp;
    }

}
