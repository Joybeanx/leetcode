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
        quickSort1(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort1(int[] nums, int from, int to) {
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
        quickSort1(nums, from, left - 1);
        quickSort1(nums, left + 1, to);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * <a href="https://leetcode.com/problems/sort-an-array/discuss/492042/7-Sorting-Algorithms-
     * (quick-sort-top-downbottom-up-merge-sort-heap-sort-etc.)">Optimized quick sort</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static int[] sortArray2(int[] nums) {
        //quickSort2(nums, 0, nums.length - 1);
        return nums;
    }
}
