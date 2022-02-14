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
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/discuss/433123/JavaC%2B%2BPython-Sliding-Window">More
     * elegant sliding window</a>
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen5(int target, int[] nums) {
        int left = 0;
        int ans = nums.length + 1;
        for (int right = 0; right < nums.length; right++) {
            target -= nums[right];
            while (target <= 0) {
                ans = Math.min(ans, right - left + 1);
                target += nums[left++];
            }
        }
        return ans % (nums.length + 1);
    }
}
