package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">Find First and Last
 * Position of Element in Sorted Array</a>
 *
 * @author Joybean
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * Three iterative binary searches
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int t = -1;
        //Find any position that holds target
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target == nums[mid]) {
                t = mid;
                break;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (t == -1) {
            return new int[] {-1, -1};
        }
        int i = left;
        int j = t;
        //Search the starting position of target in range[left,t]
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target <= nums[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        int p = t;
        int q = right;
        //Search the starting position of target in range[t,right]
        while (p <= q) {
            int mid = (p + q) >>> 1;
            if (target >= nums[mid]) {
                p = mid + 1;
            } else {
                q = mid - 1;
            }
        }
        return new int[] {i, q};
    }

    /**
     * Two iterative binary searches
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange2(int[] nums, int target) {
        int[] ans = new int[] {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        //Search the starting position of target in range[0,nums.length - 1)
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) {
            return ans;
        }
        ans[0] = left;
        right = nums.length - 1;
        //Search the ending position of target in range[left,nums.length - 1)
        while (left < right) {
            //Make mid biased to the right,so that this won't make the search range stuck
            int mid = (left + right + 1) >>> 1;
            if (target >= nums[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        ans[1] = left;
        return ans;
    }

    /**
     * Recursive binary search
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange3(int[] nums, int target) {
        //Find any position that holds target
        int idx = getTargetIndex(nums, target, 0, nums.length - 1);
        int i = idx;
        int j = idx;
        if (idx != -1) {
            //Go backward from the index to find the smallest index that holds target
            while (i - 1 >= 0 && nums[i - 1] == target) {
                i--;
            }
            //Go backward from the index to find the biggest index that holds target
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

    /**
     * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/14699
     * /Clean-iterative-solution-with-two-binary-searches-(with-explanation)">Use only one binary search implement
     * but the second binary search does not benefit from the first binary search (by akaenki)</a>
     * TODO
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange4(int[] nums, int target) {
        return null;
    }

}
