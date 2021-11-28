package com.joybean.leetcode;

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
     * TODO
     *
     * @param nums
     * @return
     */
    public static int maxWidthRamp3(int[] nums) {
        return 0;
    }
}
