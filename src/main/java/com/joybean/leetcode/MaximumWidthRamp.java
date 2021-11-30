package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/maximum-width-ramp/">Maximum Width Ramp</a>
 *
 * @author Joybean
 */
public class MaximumWidthRamp {
    /**
     * Time complexity：O(n^2)，TLE
     *
     * @param nums
     * @return
     */
    public static int maxWidthRamp1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] >= nums[i]) {
                    ans = Math.max(ans, j - i);
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/maximum-width-ramp/discuss/208348/JavaC%2B%2BPython-O(N)-Using-Stack">Binary
     * search</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static int maxWidthRamp2(int[] nums) {
        return 0;
    }

    /**
     * <a href="https://leetcode.com/problems/maximum-width-ramp/discuss/208348/JavaC%2B%2BPython-O(N)-Using-Stack">Stack
     * solution</a>
     *
     * @param nums
     * @return
     */
    public static int maxWidthRamp3(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        int ans = 0;
        //Skip unnecessary calculation when j is less than current max width
        for (int j = nums.length - 1; j >= ans; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                ans = Math.max(ans, j - stack.pop());
            }
        }
        return ans;
    }

    /**
     * <a href="https://medium.com/@yashgirdhar/maximum-width-ramp-problem-b1687a40d0bf">Two pointer</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static int maxWidthRamp4(int[] nums) {
        return 0;
    }
}
