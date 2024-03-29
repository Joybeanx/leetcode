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
        //search range [0,nums.length - 1]
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
     * <a href="https://leetcode.com/problems/search-insert-position/discuss/249092/Come-on-forget-the-binary-search-patterntemplate!-Try-understand-it!">Binary search 2</a>
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //search range [0,nums.length - 1)
        while (left < right) {
            int mid = (left + right) >>> 1;
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
        //handle the case that left stops at n-1 and desired insert position is n
        //nums=[1,3] target=5
        if (left == nums.length - 1 && nums[left] < target) {
            return left + 1;
        }
        return left;
    }


    /**
     * Binary search 3
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert3(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //search range [0,nums.length)
        while (left < right) {
            //Always gives the lower mid,so that this won't make the search range stuck
            int mid = (left + right - 1) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                //mid must not be insert position
                left = mid + 1;
            } else {
                //mid may be a possible insert position
                right = mid;
            }
        }
        return left;
    }


    /**
     * <a href="https://leetcode.com/problems/search-insert-position/discuss/423166/Binary-Search-101">Binary search 4:find lower bound</a>
     *
     * @param nums
     * @param target
     * @return
     * @see <a href ="https://github.com/python/cpython/blob/3.9/Lib/bisect.py#L50">Python bisect_left</a>
     */
    public static int searchInsert4(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //search range [0,nums.length)
        //loop invariants:
        //for each num in [0, left), num < target
        //[left, right) is not empty, left < right
        //for each num in [right, length), num >= target
        while (left < right) {
            int mid = (left + right) >>> 1;
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