package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">Largest Rectangle in Histogram</a>
 *
 * @author Joybean
 */
public class LargestRectangleInHistogram {

    /**
     * Monotonic stack
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            //or heights[i] <= heights[stack.peek()]
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                ans = Math.max(ans, height * (i - (stack.isEmpty() ? 0 : stack.peek() + 1)));
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
    public static int largestRectangleArea2(int[] heights) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            //or heights[i] <= heights[stack.peek()]
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                ans = Math.max(ans, height * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            ans = Math.max(ans, height * (heights.length - stack.peek() - 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea1(new int[] {4, 2, 0, 3, 2, 5}));
        System.out.println(largestRectangleArea1(new int[] {2, 1, 2}));
        System.out.println(largestRectangleArea1(new int[] {4, 2, 1, 5}));
        System.out.println(largestRectangleArea1(new int[] {2}));
        System.out.println(largestRectangleArea1(new int[] {2, 1, 5, 6, 2, 3}));
    }

    /**
     * Segment tree
     * TODO
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea3(int[] heights) {
        return 0;
    }

    /**
     * Divide and conquer
     * TODO
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea4(int[] heights) {
        return 0;
    }

}
