package com.joybean.leetcode;

import java.util.Deque;
import java.util.LinkedList;

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
     *
     * @param nums
     * @param k
     * @return
     */
    public static int shortestSubarray2(int[] nums, int k) {
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < prefixSum.length; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peek()] >= k) {
                ans = Math.min(i - deque.poll(), ans);
            }
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
