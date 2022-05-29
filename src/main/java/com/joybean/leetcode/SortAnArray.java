package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/sort-an-array/">Sort an Array</a>
 *
 * @author Joybean
 */
public class SortAnArray {
    /**
     * Quick sort
     *
     * @param nums
     * @return
     */
    public static int[] sortArray1(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int from, int to) {
        if (from >= to) {
            return;
        }
        int pivot = nums[from];
        int left = from;
        int right = to;
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            swap(nums, left, right);
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            swap(nums, left, right);
        }
        quickSort(nums, from, left - 1);
        quickSort(nums, left + 1, to);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
