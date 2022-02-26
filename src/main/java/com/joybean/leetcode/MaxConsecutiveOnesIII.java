package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/max-consecutive-ones-iii/">Max Consecutive Ones III</a>
 *
 * @author Joybean
 */
public class MaxConsecutiveOnesIII {
    /**
     * Sliding window 1
     *
     * @param nums
     * @param k
     * @return
     */
    public static int longestOnes1(int[] nums, int k) {
        int left = 0;
        int ans = 0;
        int zeroCnt = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCnt++;
            }
            while (zeroCnt > k && nums[left++] == 0) {
                zeroCnt--;
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }

    /**
     * Sliding window 2
     *
     * @param nums
     * @param k
     * @return
     */
    public static int longestOnes2(int[] nums, int k) {
        int left = 0;
        int zeroCnt = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCnt++;
            }
            //If we find a feasible window, we use this window size to iterate until we find a larger one(if any).
            if (zeroCnt > k && nums[left++] == 0) {
                zeroCnt--;
            }
        }
        return nums.length - left;
    }
}
