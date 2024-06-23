package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/rotate-array/">Rotate Array</a>
 *
 * @author Joybean
 */
public class RotateArray {
    /**
     * Two pointers: reverse thrice
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        //[1 2 3 4 5 6] ——> [1 2 3 4 6 5]
        reverse(nums, nums.length - k, nums.length - 1);
        //[1 2 3 4 6 5] ——> [4 3 2 1 6 5]
        reverse(nums, 0, nums.length - k - 1);
        //[4 3 2 1 6 5] ——> [5 6 1 2 3 4]
        reverse(nums, 0, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        int tmp = 0;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * <a href="https://leetcode.com/problems/rotate-array/discuss/54282/My-interpretationproof-of-the-Cyclic
     * -Replacements-Method-in-Editorial-Solution">Cyclic Replacements</a>
     * TODO
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {

    }

}
