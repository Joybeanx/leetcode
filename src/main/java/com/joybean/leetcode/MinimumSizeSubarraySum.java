package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">Minimum Size Subarray Sum</a>
 *
 * @author joybean
 */
public class MinimumSizeSubarraySum {
    /**
     * Prefix sum
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen1(int target, int[] nums) {
        //prefixSum[i] represents sum of nums[0..i-1]
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {
                if (prefixSum[j] - prefixSum[i] >= target) {
                    ans = Math.min(ans, j - i);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * Prefix sum + TreeMap
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        return 0;
    }

    /**
     * Prefix sum + Binary search
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen3(int target, int[] nums) {
        return 0;
    }

    /**
     * Sliding window
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen4(int target, int[] nums) {
        return 0;
    }
}
