package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/find-the-most-competitive-subsequence/">Find the Most
 * Competitive Subsequence</a>
 *
 * @author Joybean
 */
public class FindTheMostCompetitiveSubsequence {
    /**
     * Monotonic stack
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] mostCompetitive1(int[] nums, int k) {
        int[] ans = new int[k];
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length - k;
        for (int num : nums) {
            while (!stack.isEmpty() && num < stack.peek() && n > 0) {
                stack.pop();
                n--;
            }
            stack.push(num);
        }
        for (int i = 0; i < k && !stack.isEmpty(); i++) {
            ans[i] = stack.pollLast();
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/find-the-most-competitive-subsequence/discuss/952786/JavaC%2B%2BPython
     * -One-Pass-Stack-Solution">Array solution</a>
     * TODO
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] mostCompetitive2(int[] nums, int k) {
        return null;
    }

}
