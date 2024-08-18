package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/">Maximum Subarray</a>
 *
 * @author Joybean
 */
public class MaximumSubarray {
    /**
     * Iterative(bottom-up) DP
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int ans = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    /**
     * Iterative(bottom-up) DP with state compression
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(prev + nums[i], nums[i]);
            ans = Math.max(cur, ans);
            prev = cur;
        }
        return ans;
    }

    /**
     * Kadane's algorithm
     *
     * @param nums
     * @return
     */
    public static int maxSubArray4(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int maxSoFar = 0;
        for (int num : nums) {
            if (maxSoFar < 0) {
                maxSoFar = num;
            } else {
                maxSoFar += num;
            }
            ans = Math.max(maxSoFar, ans);

        }
        return ans;
    }

    /**
     * <a href="https://en.wikipedia.org/wiki/Maximum_subarray_problem">Kadane's algorithm</a>
     *
     * @param nums
     * @return
     */
    public static int maxSubArray5(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int maxSoFar = 0;
        for (int num : nums) {
            maxSoFar = Math.max(num, maxSoFar + num);
            ans = Math.max(maxSoFar, ans);
        }
        return ans;
    }

    /**
     * Divide and conquer
     * TODO
     *
     * @param nums
     * @return
     */
    public static int maxSubArray6(int[] nums) {
        return 0;
    }


}
