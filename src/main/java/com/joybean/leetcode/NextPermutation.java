package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/next-permutation/">Next Permutation</a>
 *
 * @author Joybean
 */
public class NextPermutation {
    /**
     * <a href="https://leetcode.com/problems/next-permutation/solutions/13867/c-from-wikipedia/?orderBy=most_votes">Two pointers using next lexicographical permutation algorithm</a>
     *
     * @param nums
     */
    public static void nextPermutation1(int[] nums) {
        int i = nums.length - 1;
        int j = i - 1;
        while (j >= 0 && nums[j] >= nums[i]) {
            i--;
            j--;
        }
        if (j == -1) {
            reverse(nums, 0);
            return;
        }
        while (i + 1 < nums.length && nums[j] < nums[i + 1]) {
            i++;
        }
        swap(nums, i, j);
        reverse(nums, j + 1);
    }

    /**
     * Optimized two pointers
     *
     * @param nums
     */
    public static void nextPermutation2(int[] nums) {
        int n = nums.length;
        int k = n - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }
        if (k == -1) {
            reverse(nums, 0);
            return;
        }
        int l = k;
        while (l + 1 < n && nums[k] < nums[l + 1]) {
            l++;
        }
        swap(nums, k, l);
        reverse(nums, k + 1);
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void reverse(int[] a, int from) {
        int i = from;
        int j = a.length - 1;
        while (i < j) {
            swap(a, i++, j--);
        }
    }
}
