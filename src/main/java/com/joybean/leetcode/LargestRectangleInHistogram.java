package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">Largest Rectangle in Histogram</a>
 *
 * @author Joybean
 */
public class LargestRectangleInHistogram {


    /**
     * Monotonic stack 1: calculate max left rectangle and max right rectangle
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        //leftMaxRect[i] represents max rectangle area before index i
        int[] maxLeftRect = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            maxLeftRect[i] = heights[i] * (i - stack.peek());
            stack.push(i);
        }
        stack.clear();
        stack.push(heights.length);
        //maxRightRect[i] represents max rectangle area after index i
        int[] maxRightRect = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (stack.peek() != heights.length && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            maxRightRect[i] = heights[i] * (stack.peek() - i);
            ans = Math.max(maxRightRect[i] + maxLeftRect[i] - heights[i], ans);
            stack.push(i);
        }
        return ans;
    }

    /**
     * Monotonic stack 2: calculate max rectangle area with height[i]
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea2(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            //or heights[i] <= heights[stack.peek()]
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                //max rectangle area with height[i]
                int maxRect = height * width;
                ans = Math.max(ans, maxRect);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            ans = Math.max(ans, height * (heights.length - (stack.isEmpty() ? 0 : stack.peek() + 1)));
        }
        return ans;
    }

    /**
     * <a href="https://www.cnblogs.com/shepherdgai/p/13551715.html">Monotonic stack using sentinel</a>
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea3(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            //or heights[i] <= heights[stack.peek()]
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                //max rectangle area with height[i]
                ans = Math.max(ans, height * width);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            ans = Math.max(ans, height * (heights.length - stack.peek() - 1));
        }
        return ans;
    }

    /**
     * Segment tree
     * TODO
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea4(int[] heights) {
        return 0;
    }

    /**
     * Divide and conquer
     * TODO
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea5(int[] heights) {
        return 0;
    }


}
