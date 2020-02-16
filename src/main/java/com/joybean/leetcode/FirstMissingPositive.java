package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/first-missing-positive/">First Missing Positive</a>
 *
 * @author Joybean
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {7, 9, -1, 1, 2}));
    }

    /**
     * The first missing positive number must be within [1, n+1].
     * The basic idea is to traversal and try to move the current value v to position whose index is v-1.
     * Then traversal again to find the first unusual value, which can not be corresponding to its index.
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            // If the current value is in the range of [1,length] and it's not at its correct position,
            // swap it to its correct position.
            if (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        int k = 0;
        while (k < nums.length && nums[k] == k + 1) { k++; }
        return k + 1;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
