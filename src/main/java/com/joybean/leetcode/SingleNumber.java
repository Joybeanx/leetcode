package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/single-number/">Single Number</a>
 *
 * @author Joybean
 */
public class SingleNumber {
    /**
     * Use XOR
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
