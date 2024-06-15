package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/">Search a 2D Matrix II</a>
 *
 * @author Joybean
 */
public class SearchA2DMatrixII {
     /*
    //wrong solution：search along the diagonal first
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int s = Math.min(m, n);
        int k = 0;
        while (k < s && matrix[k][k] < target) {
            k++;
        }
        for (int i = 0; i <= k; i++) {
            if (i < m && k < n && matrix[i][k] == target) {
                return true;
            }
        }
        if (k - 1 >= 0) {
            for (int i = k + 1; i < m; i++) {
                if (i < m && matrix[i][k - 1] == target) {
                    return true;
                }
            }
        }
        return false;
    }*/

    /**
     * Search from top left corner
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0, j = 0; i < m || j < n; ) {
            if (matrix[i][j] > target) {
                for (int row = 0; row < i; row++) {
                    if (search(matrix[row], j - 1, target)) {
                        return true;
                    }
                }
                for (int row = i; row < m; row++) {
                    if (matrix[row][0] > target) {
                        break;
                    }
                    if (search(matrix[row], 0, target)) {
                        return true;
                    }
                }
                return false;
            } else if (matrix[i][j] == target) {
                return true;
            }
            if (i == m - 1 && j == n - 1) {
                return false;
            }
            if (i != m - 1) {
                i++;
            }
            if (j != n - 1) {
                j++;
            }
        }
        return false;
    }

    private static boolean search(int[] arr, int from, int target) {
        if (from < 0) {
            return false;
        }
        for (int i = from; i < arr.length; i++) {
            if (arr[i] > target) {
                return false;
            } else if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/solutions/66140/my-concise-o-m-n-java-solution">Search from top right corner(like BST search)</a>
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int curRow = 0;
        int curCol = cols - 1;
        while (curRow < rows && curCol >= 0) {
            if (matrix[curRow][curCol] > target) {
                curCol--;
            } else if (matrix[curRow][curCol] < target) {
                curRow++;
            } else {
                return true;
            }
        }
        return false;
    }


}
