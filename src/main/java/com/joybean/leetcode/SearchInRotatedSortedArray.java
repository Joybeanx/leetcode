package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">Search in Rotated Sorted
 * Array</a>
 *
 * @author Joybean
 */
public class SearchInRotatedSortedArray {
    /**
     * Binary search
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n;
        //search range [0,nums.length), find lower bound
        while (left < right) {
            int mid = (left + right) >>> 1;
            //if nums[mid] and target are "on the different side" of nums[n-1]
            //nums=[4,5,6,7,0,1,2],target=1,convert nums as:[MAX,MAX,MAX,MAX,0,1,2]
            //nums=[4,5,6,7,0,1,2],target=6,convert nums as:[4,5,6,7,MIN,MIN,MIN]
            if ((target <= nums[n - 1]) ^ (nums[mid] <= nums[n - 1])) {
                nums[mid] = target <= nums[n - 1] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == n || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14435/Clever-idea-making-it-simple">
     * Binary search</a>
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //search range [0,nums.length), find lower bound
        while (left < right) {
            int mid = (left + right) >>> 1;
            int midVal = nums[mid];
            //If nums[mid] and target are "on the different side" of nums[0]
            //nums=[4,5,6,7,0,1,2],target=1,convert nums as:[MAX,MAX,MAX,MAX,0,1,2]
            //nums=[4,5,6,7,0,1,2],target=6,convert nums as:[4,5,6,7,MIN,MIN,MIN]
            //Should not use target >= nums[right] ^ nums[mid] >= nums[right] because right is out of index range
            if (target >= nums[0] ^ nums[mid] >= nums[0]) {
                midVal = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (midVal < target) {
                left = mid + 1;
            } else if (midVal > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
