package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">Move Zeroes</a>
 *
 * @author Joybean
 */
public class MoveZeroes {
    /**
     * Move non-zeros to the front
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(i, j++, nums);
            }
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * <a href="https://leetcode.com/problems/move-zeroes/solutions/72000/1ms-java-solution/">Optimize swap (by
     * Walkboy)</a>
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int leftMostZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //i >= leftMostZeros is always true
                //i > leftMostZeroIndex means we found zero before i
                if (i > leftMostZeros) {
                    nums[leftMostZeros] = nums[i];
                    nums[i] = 0;
                }
                leftMostZeros++;
            }
        }
    }

    public static void moveZeroes3(int[] nums) {
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

    /**
     * <a
     * href="https://leetcode.com/problems/move-zeroes/solutions/172432/the-easiest-but-unusual-snowball-java-solution
     * -beats-100-o-n-clear-explanation/">Count zeros</a>
     *
     * @param nums
     */
    public static void moveZeroes4(int[] nums) {
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
