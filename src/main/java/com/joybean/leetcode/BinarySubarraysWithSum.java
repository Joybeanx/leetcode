package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/binary-subarrays-with-sum/">Binary Subarrays With Sum</a>
 *
 * @author Joybean
 * @see SubarraySumEqualsK
 */
public class BinarySubarraysWithSum {
    /**
     * Prefix sum
     *
     * @param nums
     * @param goal
     * @return
     */
    public static int numSubarraysWithSum1(int[] nums, int goal) {
        int ans = 0;
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            if (prefixSum >= goal) {
                ans += count[prefixSum - goal];
            }
            count[prefixSum]++;
        }
        return ans;
    }
}
