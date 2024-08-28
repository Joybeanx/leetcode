package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/next-permutation/">Next Permutation</a>
 *
 * @author Joybean
 */
public class NextPermutation {
    /**
     * Two pointers
     *
     * @param nums
     */
    public static void nextPermutation1(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int i = n - 2;
        while (i >= 1 && nums[i + 1] <= nums[i]) {
            i--;
        }
        int j = n - 1;
        while (j > i && nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i == j ? 0 : i + 1, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    /**
     * <a href="https://leetcode.com/problems/next-permutation/solutions/13867/c-from-wikipedia/?orderBy=most_votes">Two
     * pointers using next lexicographical permutation algorithm</a>
     *
     * @param nums
     */
    public static void nextPermutation2(int[] nums) {
        //case: [2,4,3,1]
        //1. Find the largest index i such that nums[i] < nums[i + 1].
        int j = nums.length - 1;
        int i = j - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            j--;
            i--;
        }
        //nums is in none increasing order, reverse whole array, case: [3,2,1]
        if (i == -1) {
            reverse(nums, 0);
            return;
        }
        //2. Find the largest index j > i such that  nums[j] > nums[i]
        while (j + 1 < nums.length && nums[i] < nums[j + 1]) {
            j++;
        }
        //3. Swap nums[i] and nums[j]: [2,4,3,1] -> [3,4,2,1]
        swap(nums, i, j);
        //4. Reverse the sub-array nums[i + 1:]: [3,4,2,1] -> [3,1,2,4]
        reverse(nums, i + 1);
    }

    /**
     * Two pointers using next lexicographical permutation algorithm
     *
     * @param nums
     */
    public static void nextPermutation3(int[] nums) {
        //case: [2,4,3,1]
        //1. Find the largest index i such that nums[i] < nums[i + 1].
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //nums is in none increasing order, reverse whole array, case: [3,2,1]
        if (i < 0) {
            reverse(nums, 0);
            return;
        }
        int j = i;
        //2. Find the largest index j > i such that  nums[j] > nums[i]
        while (j + 1 < n && nums[i] < nums[j + 1]) {
            j++;
        }
        //3. Swap nums[i] and nums[j]: [2,4,3,1] -> [3,4,2,1]
        swap(nums, i, j);
        //4. Reverse the sub-array nums[i + 1:]: [3,4,2,1] -> [3,1,2,4]
        reverse(nums, i + 1);
    }

    /**
     * Two pointers using next lexicographical permutation algorithm
     *
     * @param nums
     */
    public void nextPermutation4(int[] nums) {
        //1. Find the largest index i such that nums[i] < nums[i + 1]. If no such index , just reverse
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i == -1) {
            reverse(nums, 0);
            return;
        }
        //2. Find the largest index j > i such that  nums[j] > nums[i]
        for (int j = nums.length - 1; j > 0; j--) {
            if (nums[j] > nums[i]) {
                //3. Swap nums[i] and nums[j]
                swap(nums, i, j);
                //4. Reverse the sub-array nums[i + 1:]
                reverse(nums, i + 1);
                return;
            }
        }

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
