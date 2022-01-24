package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/">Maximum
 * Side Length of a Square with Sum Less than or Equal to Threshold</a>
 *
 * @author Joybean
 */
public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
    /**
     * Prefix sum
     *
     * @param mat
     * @param threshold
     * @return
     */
    public static int maxSideLength1(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            int rowSum = 0;
            for (int j = 1; j < n + 1; j++) {
                rowSum += mat[i - 1][j - 1];
                prefixSum[i][j] = rowSum + prefixSum[i - 1][j];
            }
        }
        int ans = 0;
        for (int i = m; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                int sideLength = Math.min(i, j);
                for (int k = sideLength; k >= 1; k--) {
                    //Calculate the sum of square whose right-down corner is mat[i-1][j-1] and side length is k
                    int squareSum =
                        prefixSum[i][j] - prefixSum[i][j - k] - prefixSum[i - k][j] + prefixSum[i - k][j - k];
                    if (squareSum <= threshold) {
                        ans = Math.max(k, ans);
                    }
                }
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to
     * -threshold/discuss/451843/Java-PrefixSum-solution">Optimized prefix sum</a>
     *
     * @param mat
     * @param threshold
     * @return
     */
    public static int maxSideLength2(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            int rowSum = 0;
            for (int j = 1; j < n + 1; j++) {
                rowSum += mat[i - 1][j - 1];
                prefixSum[i][j] = rowSum + prefixSum[i - 1][j];
            }
        }
        for (int k = Math.min(m, n); k >= 1; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    //Calculate the sum of square whose left-top corner is mat[i][j] and side length is k
                    int squareSum =
                        prefixSum[i + k][j + k] - prefixSum[i + k][j] - prefixSum[i][j + k] + prefixSum[i][j];
                    if (squareSum <= threshold) {
                        return k;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Prefix sum + Binary search
     * TODO
     *
     * @param mat
     * @param threshold
     * @return
     */
    public static int maxSideLength3(int[][] mat, int threshold) {
        return 0;
    }
}
