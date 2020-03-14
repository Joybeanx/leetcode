package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">Find First and Last
 * Position of Element in Sorted Array</a>
 *
 * @author Joybean
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange1(int[] nums, int target) {
        //find any index that holds target
        int idx = getTargetIndex(nums, target, 0, nums.length - 1);
        int i = idx;
        int j = idx;
        if (idx != -1) {
            //go backward from the index to find the smallest index that holds target
            while (i - 1 >= 0 && nums[i - 1] == target) {
                i--;
            }
            //go backward from the index to find the biggest index that holds target
            while (j + 1 < nums.length && nums[j + 1] == target) {
                j++;
            }
        }
        return new int[] {i, j};
    }

    public static int getTargetIndex(int[] nums, int target, int start, int end) {
        if (start >= nums.length || end >= nums.length || target > nums[end] || target < nums[start]) {
            return -1;
        }
        if (target == nums[start]) {
            return start;
        }
        if (target == nums[end]) {
            return end;
        }
        int mi = (start + end) / 2;
        int targetIdx;
        if ((targetIdx = getTargetIndex(nums, target, start, mi)) != -1) {
            return targetIdx;
        }
        return getTargetIndex(nums, target, mi + 1, end);
    }

}
