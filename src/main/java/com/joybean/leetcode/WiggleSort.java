package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/wiggle-sort/">Wiggle Sort</a>
 *
 * @author Joybean
 */
public class WiggleSort {

    /**
     * Swap
     * https://www.lintcode.com/problem/508/
     *
     * @return
     */
    public static void wiggleSort(int[] nums) {
        //If i is even and nums[i] > nums[i+1], then swap the elements
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i & 1) == 0) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
                //If i is odd and nums[i] < nums[i+1], then swap the elements
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
