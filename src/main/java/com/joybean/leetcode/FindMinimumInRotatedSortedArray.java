package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/">Find Minimum in Rotated Sorted Array</a>
 *
 * @author Joybean
 */
public class FindMinimumInRotatedSortedArray {
    /**
     * Convert it to binary search problem
     *
     * @param nums
     * @return
     */
    public static int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int midValue = nums[mid];
            //[4,5,6,7,0,1,2]  ->  [MIN,MIN,MIN,MIN,0,1,2]
            if (midValue > nums[right]) {
                midValue = Integer.MIN_VALUE;
            }
            //binary search: find upper bound
            if (midValue > -5001) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    /**
     *
     * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solutions/158940/beat-100-very-simple-python-very-detailed-explanation/">Elegant solution</a>
     *
     * @param nums
     * @return
     */
    public static int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
