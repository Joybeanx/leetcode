package com.joybean.leetcode;

import java.util.HashMap;
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
        Map<Integer, Integer> counter = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            min = Math.min(nums[right], min);
            max = Math.max(nums[right], max);
            counter.merge(nums[right], 1, Integer::sum);
            while (max - min > limit) {
                counter.merge(nums[left], -1, Integer::sum);
                if (counter.remove(nums[left], 0)) {
                    if (nums[left] == min) {
                        min =
                            counter.keySet().stream().mapToInt(Integer::intValue).min().orElse(0);
                    } else if (nums[left] == max) {
                        max = counter.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);
                    }
                }
                left++;
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to
     * -limit/discuss/609771/JavaC%2B%2BPython-Deques-O(N)">Sliding window with two dequeues</a>
     * TODO
     *
     * @param nums
     * @param limit
     * @return
     */
    public static int longestSubarray2(int[] nums, int limit) {
        return 0;
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
