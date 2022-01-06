package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/binary-search/">Binary Search</a>
 *
 * @author Joybean
 */
public class BinarySearch {
    /**
     * Binary search 1
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
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
        return -1;
    }

    /**
     * Binary search 2
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //search range [left,right)
        while (left < right) {
            //avoid overflow
            int mid = (left + right) >>> 1;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
