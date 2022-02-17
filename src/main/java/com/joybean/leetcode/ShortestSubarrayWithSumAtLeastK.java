package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/">Shortest Subarray with Sum at Least
 * K</a>
 *
 * @author joybean
 */
public class ShortestSubarrayWithSumAtLeastK {
    /**
     * Sliding window:Time Limit Exceeded
     *
     * @param nums
     * @param k
     * @return
     */
    public static int shortestSubarray1(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        int positiveSum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            if (nums[right] > 0) {
                positiveSum += nums[right];
            }
            if (positiveSum < k) {
                continue;
            }
            int tmpSum = sum;
            int tmpPositiveSum = positiveSum;
            int tmpLeft = left;
            while (tmpLeft <= right) {
                if (tmpSum >= k) {
                    sum = tmpSum;
                    positiveSum = tmpPositiveSum;
                    left = tmpLeft;
                    ans = Math.min(ans, right - left + 1);
                }
                tmpSum -= nums[tmpLeft];
                if (nums[tmpLeft] > 0) {
                    tmpPositiveSum -= nums[tmpLeft];
                }
                tmpLeft++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * <a href="https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/C%2B%2BJavaPython
     * -O(N)-Using-Deque">Monotonic queue</a>
     * TODO
     *
     * @param nums
     * @param k
     * @return
     */
    public static int shortestSubarray2(int[] nums, int k) {
        return 0;
    }
}
