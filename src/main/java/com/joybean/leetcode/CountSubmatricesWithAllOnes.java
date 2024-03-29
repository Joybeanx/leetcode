package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/count-submatrices-with-all-ones/">Count Submatrices With All Ones</a>
 *
 * @author Joybean
 */
public class CountSubmatricesWithAllOnes {
    /**
     * <a href="https://krains.gitee.io/blogs/Algorithm&Data%20Structure/LeetCode/1504
     * .%20%E7%BB%9F%E8%AE%A1%E5%85%A8%201%20%E5%AD%90%E7%9F%A9%E5%BD%A2.html#%E6%9A%B4%E5%8A%9B%E8%A7%A3">Brute
     * force</a>
     *
     * @param mat
     * @return
     */
    public static int numSubmat1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;

        // heights of every 1
        int[][] heights = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    heights[i][j] = i == 0 ? 1 : heights[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) { continue; }
                int min = heights[i][j];
                // Moving from right to left,add up current minimum height
                for (int k = j; k >= 0 && heights[i][k] != 0; k--) {
                    min = Math.min(min, heights[i][k]);
                    ans += min;
                }
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/720265/Java-Detailed
     * -Explanation-From-O(MNM)-to-O(MN)-by-using-Stack">Brute force 2</a>
     *
     * @param mat
     * @return
     */
    public static int numSubmat2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            //heights[k] == 1 means all values in column k from row i to j are 1
            int[] heights = new int[n];
            Arrays.fill(heights, 1);
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    heights[k] &= mat[j][k];
                }
                ans += count(heights);
            }
        }
        return ans;
    }

    private static int count(int[] heights) {
        int res = 0;
        int length = 0;
        for (int height : heights) {
            if (height == 1) {
                res += ++length;
            } else {
                length = 0;
            }
        }
        return res;
    }

    /**
     * <a href="https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/720265/Java-Detailed
     * -Explanation-From-O(MNM)-to-O(MN)-by-using-Stack">Monotonic stack</a>
     *
     * @param mat
     * @return
     */
    public static int numSubmat3(int[][] mat) {
        int ans = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans += helper(heights);
        }
        return ans;
    }

    /**
     * Sum of Subarray Minimums
     *
     * @param heights
     * @return
     * @see SumOfSubarrayMinimums
     */
    private static int helper(int[] heights) {
        //nled[i] = distance from the ith element to next less element
        int[] nled = new int[heights.length];
        //pled[i] = distance from the ith element to previous less element
        int[] pled = new int[heights.length];
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            nled[i] = heights.length - i;
            while (!stack1.isEmpty() && heights[stack1.peek()] > heights[i]) {
                nled[stack1.peek()] = i - stack1.pop();
            }
            stack1.push(i);
            pled[i] = i + 1;
            while (!stack2.isEmpty() && heights[stack2.peek()] > heights[i]) {
                stack2.pop();
            }
            pled[i] = i - (stack2.isEmpty() ? -1 : stack2.peek());
            stack2.push(i);
        }
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            ans = ans + nled[i] * pled[i] * heights[i];
        }
        return ans;
    }
}
