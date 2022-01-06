package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/search-insert-position/">Search Insert Position</a>
 *
 * @author Joybean
 */
public class SearchInsertPosition {
    /**
     * Binary search 1
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //search range [left,right]
        while (left <= right) {
            //avoid overflow
            int mid = (left + right) >>> 1;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * Binary search 2
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //search range [left,right)
        while (left < right) {
            //avoid overflow
            int mid = (left + right - 1) >>> 1;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}