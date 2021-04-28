package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/">Subarray Sum Equals K</a>
 *
 * @author Joybean
 */
public class SubarraySumEqualsK {
    /**
     * Prefix sum array
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum1(int[] nums, int k) {
        //prefixSum[i] presents sum of nums[0..i-1]
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int cnt = 0;
        //Why not use set? Think about this case: [1, -1, 0], 0
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prefixSum.length; i++) {
            if (map.containsKey(prefixSum[i] - k)) {
                cnt += map.get(prefixSum[i] - k);
            }
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }
        return cnt;
    }

    public static int subarraySum2(int[] nums, int k) {
        int cnt = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //base case
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                cnt += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
