package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/">Find the Duplicate Number</a>
 *
 * @author Joybean
 */
public class FindTheDuplicateNumber {

    /**
     * <a href="https://leetcode.com/problems/find-the-duplicate-number/solutions/72846/my-easy-understood-solution
     * -with-o-n-time-and-o-1-space-without-modifying-the-array-with-clear-explanation/">Floyd's cycle detection algorithm</a>
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
}
