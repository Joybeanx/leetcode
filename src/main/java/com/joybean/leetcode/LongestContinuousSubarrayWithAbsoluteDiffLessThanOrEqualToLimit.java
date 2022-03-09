package com.joybean.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/">Longest
 * Continuous Subarray With Absolute Diff Less Than or Equal to Limit</a>
 *
 * @author Joybean
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    /**
     * Sliding window
     *
     * @param nums
     * @param limit
     * @return
     */
    public static int longestSubarray1(int[] nums, int limit) {
        int left = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        int ans = 0;
        Map<Integer, Integer> windowCounts = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            min = Math.min(nums[right], min);
            max = Math.max(nums[right], max);
            windowCounts.merge(nums[right], 1, Integer::sum);
            while (max - min > limit) {
                windowCounts.merge(nums[left], -1, Integer::sum);
                if (windowCounts.remove(nums[left], 0)) {
                    if (nums[left] == min) {
                        min = windowCounts.keySet().stream().mapToInt(Integer::intValue).min().orElse(0);
                    } else if (nums[left] == max) {
                        max = windowCounts.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);
                    }
                }
                left++;
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/discuss/609743/Java-Detailed-Explanation-Sliding-Window-Deque-O(N)">Sliding window with two dequeues</a>
     *
     * @param nums
     * @param limit
     * @return
     */
    public static int longestSubarray2(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);
            while (!minDeque.isEmpty() && nums[right] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);
            while (maxDeque.peek() - minDeque.peek() > limit) {
                if (maxDeque.peek() == nums[left]) {
                    maxDeque.poll();
                }
                if (minDeque.peek() == nums[left]) {
                    minDeque.poll();
                }
                left++;
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to
     * -limit/discuss/609771/JavaC%2B%2BPython-Deques-O(N)">TreeMap</a>
     * TODO
     *
     * @param nums
     * @param limit
     * @return
     */
    public static int longestSubarray3(int[] nums, int limit) {
        return 0;
    }
}
