package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/">Find the Duplicate Number</a>
 *
 * @author Joybean
 */
public class FindTheDuplicateNumber {
    /**
     * <a href="https://leetcode.com/problems/find-the-duplicate-number/editorial/">Sum of Set Bits</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static int findDuplicate1(int[] nums) {
        return 0;
    }

    /**
     * <a href="https://leetcode.com/problems/find-the-duplicate-number/solutions/1892921/9-approaches-count-hash-in-place-marked-sort-binary-search-bit-mask-fast-slow-pointers">Binary search using Pigeonhole Principle</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        return 0;
    }

    /**
     * <a href="https://leetcode.com/problems/find-the-duplicate-number/editorial/">Floyd's cycle detection algorithm</a>
     *
     * @param nums
     * @return
     */
    public static int findDuplicate3(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate2(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate2(new int[]{3, 1, 3, 4, 2}));
    }
}
