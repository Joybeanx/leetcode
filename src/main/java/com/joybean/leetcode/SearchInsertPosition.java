package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/search-insert-position/">Search Insert Position</a>
 *
 * @author Joybean
 */
public class SearchInsertPosition {
    /**
     * Binary search
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert1(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            //avoid overflow
            int mid = (left + right - 1) >>> 1;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}