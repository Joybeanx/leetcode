package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/majority-element/">Majority Element</a>
 *
 * @author Joybean
 */
public class MajorityElement {
    /**
     * Sort and count
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        int threshold = nums.length / 2;
        int streak = 0;
        int prev = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num != prev) {
                streak = 0;
            }
            streak++;
            if (streak > threshold) {
                return num;
            }
            prev = num;

        }
        return 0;
    }

    /**
     * Sort and pick: the majority element always occupy the middle position when the array is sorted
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * <a href="https://leetcode.cn/problems/majority-element/solutions/2757284/boyer-moore-tou-piao-suan-fa-yong
     * -qing-j-x3kn/?envType=problem-list-v2&envId=2cktkvj">Boyer–Moore majority vote algorithm</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static int majorityElement3(int[] nums) {
        return 0;
    }
}
