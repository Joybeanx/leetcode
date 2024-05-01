package com.joybean.leetcode;

import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Kth Largest Element in an Array</a>
 *
 * @author Joybean
 */
public class KthLargestElementInAnArray {
    /**
     * Quick select
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] nums, int k) {
        partition1(nums, k, 0, nums.length - 1);
        return nums[k - 1];
    }

    private static void partition1(int[] nums, int k, int from, int to) {
        if (k - 1 < from || k - 1 > to) {
            return;
        }
        if (from >= to) {
            return;
        }
        //random partition pivot for better performance
        swap(from, new Random().nextInt(to - from + 1) + from, nums);
        int i = from + 1;
        int j = to;
        int t = nums[from];
        while (true) {
            while (i <= to && nums[i] >= t) {
                i++;
            }
            //j >= start not necessary
            while (nums[j] < t) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(i, j, nums);
        }
        swap(from, j, nums);
        partition1(nums, k, j + 1, to);
        partition1(nums, k, from, j - 1);
    }

    /**
     * Quick select using Hoare partition
     *
     * @param nums
     * @param k
     * @return
     * @see SortAnArray#sortArray3(int[])
     */
    public static int findKthLargest2(int[] nums, int k) {
        return findKthLargestInternal(nums, 0, nums.length - 1, k - 1);
    }

    static int findKthLargestInternal(int[] nums, int i, int j, int k) {
        if (i == j) {
            return nums[i];
        }
        int pi = partition2(nums, i, j);
        if (pi < k) {
            return findKthLargestInternal(nums, pi + 1, j, k);
        }
        return findKthLargestInternal(nums, i, pi, k);
    }

    private static int partition2(int[] nums, int left, int right) {
        int i = left - 1;
        int j = right + 1;
        //or pivot = nums[left]
        //must not be pivot = nums[right],because it would cause infinite loop in some case,such as:[7, 5, 3, 1]
        int pivot = nums[(left + right) >>> 1];
        while (true) {
            do {
                i++;
            } while (nums[i] > pivot);
            do {
                j--;
            } while (nums[j] < pivot);
            if (i >= j) {
                return j;
            }
            swap(i, j, nums);
        }
    }


    /**
     * <a href ="https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/3906260/100-3-approaches-video-heap-quickselect-sorting/">Quick select using Lomuto partition</a>
     *
     * @param nums
     * @param k
     * @return
     * @see BinarySearch#search4(int[], int)
     * TODO
     */
    public static int findKthLargest3(int[] nums, int k) {
        return 0;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
