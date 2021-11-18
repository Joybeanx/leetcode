package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/daily-temperatures/">Daily Temperatures</a>
 *
 * @author Joybean
 */
public class DailyTemperatures {
    /**
     * Monotonic stack
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures1(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                ans[stack.peek()] = i - stack.poll();
            }
            stack.push(i);
        }
        return ans;
    }
}
