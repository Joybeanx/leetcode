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
            if (nums[mid] == target) {
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
            //Always gives the lower mid,so that this won't make the search range stuck
            int mid = (left + right - 1) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //mid may be a possible insert position
                right = mid;
            }
        }
        return left;
    }

    /**
     * <a href="https://leetcode.com/problems/search-insert-position/discuss/249092/Come-on-forget-the-binary-search-patterntemplate!-Try-understand-it!">Binary search 3</a>
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //right could be the result
                right = mid;
            }
        }

        //We need a post-processing because there is one element left at the end
        return nums[left] < target ? left + 1 : left;
    }


    /**
     * <a href="https://leetcode.com/problems/search-insert-position/discuss/423166/Binary-Search-101">Binary search 4</a>
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert4(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //search range [left,right)
        while (left < right) {
            //Always gives the lower mid,so that this won't make the search range stuck
            int mid = (left + right - 1) >>> 1;
            //100% sure logic
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //mid may be a possible insert position
                right = mid;
            }
        }
        return left;
    }
}