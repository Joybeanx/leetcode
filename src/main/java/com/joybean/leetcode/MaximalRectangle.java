package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Stack;

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
     * Monotonic stack: based on {@link LargestRectangleInHistogram}
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle2(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] heights = new int[m][n];
        for (int i = 0; i < m; i++) {
            heights[i][0] = matrix[i][0] == '1' ? 1 : 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[i][j] = heights[i][j - 1] + 1;
                }
            }
        }
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < m; row++) {
                while (stack.peek() != -1 && heights[row][col] < heights[stack.peek()][col]) {
                    int top = stack.pop();
                    int height = heights[top][col];
                    //rather than height = row - top,failed case: [["1","1","1"],["1","1","0"],["1","1","0"],["1","0","0"],["0","1","0"]]
                    int width = row - stack.peek() - 1;
                    ans = Math.max(height * width, ans);
                }
                stack.push(row);
            }
            while (stack.peek() != -1) {
                int top = stack.pop();
                int height = heights[top][col];
                int width = m - stack.peek() - 1;
                ans = Math.max(height * width, ans);
            }
        }
        return ans;
    }

    /**
     * Optimized monotonic stack: based on {@link LargestRectangleInHistogram}
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle3(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] heights = new int[n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
                while (stack.peek() != -1 && heights[col] < heights[stack.peek()]) {
                    int top = stack.pop();
                    int height = heights[top];
                    //rather than width = col - top,failed case: [["1","1","1"],["1","1","0"],["1","1","0"],["1","0","0"],["0","1","0"]]
                    int width = col - stack.peek() - 1;
                    ans = Math.max(height * width, ans);
                }
                stack.push(col);
            }
            while (stack.peek() != -1) {
                int top = stack.pop();
                int height = heights[top];
                int width = n - stack.peek() - 1;
                ans = Math.max(height * width, ans);
            }
        }
        return ans;
    }
}
