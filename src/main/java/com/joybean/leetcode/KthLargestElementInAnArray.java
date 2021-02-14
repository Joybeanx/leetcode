package com.joybean.leetcode;

import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array//">Kth Largest Element in an Array</a>
 *
 * @author Joybean
 */
public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        partition(nums, k, 0, nums.length - 1);
        return nums[k - 1];
    }

    private static void partition(int[] nums, int k, int start, int to) {
        if (k - 1 < start || k - 1 > to) {
            return;
        }
        if (start >= to) {
            return;
        }
        //random partition pivot for better performance
        swap(start, new Random().nextInt(to - start + 1) + start, nums);
        int i = start + 1;
        int j = to;
        int t = nums[start];
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
        swap(start, j, nums);
        partition(nums, k, j + 1, to);
        partition(nums, k, start, j - 1);
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
