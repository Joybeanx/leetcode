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
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return ++slow;
    }

    /**
     * Two pointers
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }
        return ++slow;
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
