package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/132-pattern/">132 Pattern</a>
 *
 * @author Joybean
 */
public class OneThreeTwoPattern {
    /**
     * Time complexity：O(n^2)，TLE
     *
     * @param nums
     * @return
     */
    public static boolean find132pattern1(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i] && nums[j] > min) {
                    return true;
                }
            }
            min = Math.min(min, nums[i]);
        }
        return false;
    }

    /**
     * One-pass O(n) solution
     * TODO
     *
     * @param nums
     * @return
     */
    public static boolean find132pattern2(int[] nums) {
        return false;
    }

    /**
     * Stack solution
     *
     * @param nums
     * @return
     */
    public static boolean find132pattern3(int[] nums) {
        //The third num of 132，i.e 2
        int third = Integer.MIN_VALUE;
        //The stack is containing the highest numbers(monotonically decreasing) so far, and third is the
        // lower number after the highest numbers. So, this satisfies the 32 pattern.
        // Now, we will just keep updating third and pop top when we encounter a number which is greater than the
        // highest number.
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int cur = nums[i];
            if (cur < third) {
                return true;
            }
            while (!stack.isEmpty() && cur > stack.peek()) {
                third = stack.pop();
            }
            stack.push(cur);
        }
        return false;
    }
}
