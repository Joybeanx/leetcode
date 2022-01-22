package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/find-pivot-index/">Find Pivot Index</a>
 *
 * @author Joybean
 */
public class FindPivotIndex {
    /**
     * Prefix sum
     *
     * @param nums
     * @return
     */
    public static int pivotIndex1(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int total = prefixSum[prefixSum.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (total - prefixSum[i + 1] == prefixSum[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * <a href="https://leetcode.com/problems/find-pivot-index/solution/">O(1) space prefix sum</a>
     *
     * @param nums
     * @return
     */
    public static int pivotIndex2(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int x : nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
