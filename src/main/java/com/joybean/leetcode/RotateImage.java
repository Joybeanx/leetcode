package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/rotate-image/">Rotate Image</a>
 * Created by Joybean
 */
public class RotateImage {

    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int lenToSwap = row.length - i - 1;
            for (int j = i; j < lenToSwap; j++) {
                int value = row[j];
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
}
