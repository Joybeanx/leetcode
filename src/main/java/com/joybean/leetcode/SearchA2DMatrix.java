package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/">Search a 2D Matrix</a>
 *
 * @author Joybean
 */
public class SearchA2DMatrix {
    /**
     * Binary search
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m * n;
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] > target) {
                right = mid - 1;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return matrix[left / n][left % n] == target;
    }

    /**
     * <a href="https://leetcode.com/problems/search-a-2d-matrix/solutions/26220/don-t-treat-it-as-a-2d-matrix-just
     * -treat-it-as-a-sorted-list/">Binary search</a>
     *
     * @param matrix
     * @param target
     * @return
     * @see <a href ="https://github.com/python/cpython/blob/3.9/Lib/bisect.py#L50">Python bisect_left</a>
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m * n;
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (matrix[mid / n][mid % n] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return matrix[left / n][left % n] == target;
    }
}
