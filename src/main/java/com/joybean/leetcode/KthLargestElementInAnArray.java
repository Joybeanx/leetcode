package com.joybean.leetcode;

import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array//">Kth Largest Element in an Array</a>
 *
 * @author Joybean
 */
public class KthLargestElementInAnArray {
    /**
     * Recursion partition
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] nums, int k) {
        partition1(nums, k, 0, nums.length - 1);
        return nums[k - 1];
    }

    /**
     * Loop partition
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        int from = 0;
        int to = nums.length - 1;
        while (true) {
            int pivot = partition2(nums, from, to);
            if (pivot > k - 1) {
                to = pivot - 1;
            } else if (pivot < k - 1) {
                from = pivot + 1;
            } else {
                break;
            }
        }
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

    private static int partition2(int[] nums, int from, int to) {
        //random partition pivot for better performance
        swap(from, new Random().nextInt(to - from + 1) + from, nums);
        int i = from + 1;
        int j = to;
        int t = nums[from];
        while (true) {
            while (i <= to && nums[i] >= t) {
                i++;
            }
            while (nums[j] < t) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(i, j, nums);
        }
        swap(from, j, nums);
        return j;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
