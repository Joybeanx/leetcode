package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/number-of-visible-people-in-a-queue/">Number of Visible People in a Queue</a>
 *
 * @author Joybean
 */
public class NumberOfVisiblePeopleInAQueue {
    /**
     * Brute force:TLE
     *
     * @param heights
     * @return
     */
    public static int[] canSeePersonsCount1(int[] heights) {
        int[] ans = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int max = 0;
            int cnt = 0;
            for (int j = i + 1; j < heights.length; j++) {
                if (Math.min(heights[i], heights[j]) > max) {
                    cnt++;
                }
                max = Math.max(max, heights[j]);
            }
            ans[i] = cnt;
        }
        return ans;
    }

    /**
     * Monotonic stack
     *
     * @param heights
     * @return
     */
    public static int[] canSeePersonsCount2(int[] heights) {
        int[] ans = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        //Moving from end to start,use monotonically decreasing stack
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
                ans[i]++;
            }
            if (!stack.isEmpty()) {
                ans[i]++;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/number-of-visible-people-in-a-queue/discuss/1359707/JavaC%2B%2BPython
     * -Stack-Solution-Next-Greater-Element">Monotonic stack</a>
     *
     * @param heights
     * @return
     */
    public static int[] canSeePersonsCount3(int[] heights) {
        int[] ans = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        //Moving from start to end,use monotonically decreasing stack
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                ans[stack.pop()]++;
            }
            if (!stack.isEmpty()) {
                ans[stack.peek()]++;
            }
            stack.push(i);
        }
        return ans;
    }

}
