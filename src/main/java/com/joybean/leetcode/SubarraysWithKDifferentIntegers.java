package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/subarrays-with-k-different-integers/">Subarrays with K Different Integers</a>
 *
 * @author Joybean
 */
public class SubarraysWithKDifferentIntegers {
    /**
     * Sliding window:TLE
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraysWithKDistinct1(int[] nums, int k) {
        int left = 0;
        int ans = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            countMap.merge(nums[right], 1, Integer::sum);
            if (countMap.size() > k) {
                ans += countInRange(left, right - 1, nums, k);
                while (countMap.size() > k) {
                    countMap.merge(nums[left], -1, Integer::sum);
                    countMap.remove(nums[left++], 0);
                }
            }
            if (countMap.size() == k && right == nums.length - 1) {
                ans += countInRange(left, right, nums, k);
            }
        }
        return ans;
    }

    private static int countInRange(int start, int end, int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = start;
        for (int right = start; right <= end; right++) {
            countMap.merge(nums[right], 1, Integer::sum);
            while (countMap.size() == k) {
                countMap.merge(nums[left], -1, Integer::sum);
                countMap.remove(nums[left++], 0);
            }
            ans += left - start;
        }
        return ans;
    }
}
