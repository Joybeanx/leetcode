package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Remove Duplicates from Sorted Array</a>
 *
 * @author Joybean
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * Two pointers
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        return ++left;
    }

    /**
     * Two pointers
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
            }
        }
        return ++left;
    }

    /**
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/discuss/11780/5-lines-C%2B%2BJava
     * -nicer-loops">Nicer loop</a>
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates3(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num != nums[i]) {
                nums[++i] = num;
            }
        }
        return ++i;
    }
}
