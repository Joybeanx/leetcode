package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">Search in Rotated Sorted
 * Array</a>
 *
 * @author Joybean
 */
public class SearchInRotatedSortedArray {
    /**
     * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14435/Clever-idea-making-it-simple">
     * Binary search</a>
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            // If nums[mid] and target are "on the different side" of nums[0]
            if (target >= nums[0] ^ nums[mid] >= nums[0]) {
                nums[mid] = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
