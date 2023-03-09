package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">Move Zeroes</a>
 *
 * @author Joybean
 */
public class MoveZeroes {
    public static void moveZeroes1(int[] nums) {
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                nums[i - zeros] = nums[i];
                if (zeros != 0) {
                    nums[i] = 0;
                }
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else if (zeros > 0) {
                nums[i - zeros] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
