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
        //search range [0,nums.length - 1]
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
        //search range [0,nums.length - 1)
        while (left < right) {
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
        return nums[left] == target ? left : -1;
    }


    /**
     * Binary search 3
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //search range [0,nums.length - 1)
        while (left < right) {
            //avoid overflow
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * <a href="https://www.zhihu.com/question/36132386">Binary search 3:find lower bound</a>
     *
     * @param nums
     * @param target
     * @return
     * @see <a href ="https://github.com/python/cpython/blob/3.9/Lib/bisect.py#L50">Python bisect_left</a>
     */
    public static int search4(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //search range [0,nums.length)
        while (left < right) {
            //avoid overflow
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //Integer in [0,left) must be less than target
        if (left != nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }
}
