package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximal-rectangle/">Maximal Rectangle</a>
 *
 * @author Joybean
 */
public class MaximalRectangle {
    /**
     * <a href="https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution">DP</a>
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, maxArea = 0;
        //left[i] record the left most index j which satisfies that for any index k from j to i,height[k] >= height[i]
        int[] left = new int[n];
        //right[i] record the right most index j which satisfies that for any index k from i to j,height[k] >= height[i]
        int[] right = new int[n];
        //height[i] record the current number of continuous '1' in column i
        int[] height = new int[n];
        Arrays.fill(right, n - 1);
        for (int i = 0; i < m; i++) {
            int rb = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rb);
                } else {
                    right[j] = n - 1;
                    rb = j - 1;
                }
            }
            int lb = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], lb);
                    height[j]++;
                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    lb = j + 1;
                }
            }
        }
        return maxArea;
    }

    /**
     * Based on {@link LargestRectangleInHistogram}
     * TODO
     * @param matrix
     * @return
     */
    public static int maximalRectangle2(char[][] matrix) {
        return 0;
    }
}
