package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/remove-element/">Remove Element</a>
 *
 * @author Joybean
 */
public class RemoveElement {
    /**
     * Two pointers
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    /**
     * Nicer loop
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int num : nums) {
            if (num != val) {
                nums[i++] = num;
            }
        }
        return i;
    }
}
