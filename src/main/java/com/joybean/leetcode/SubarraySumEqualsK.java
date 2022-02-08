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
     * Two-pass prefix sum
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum1(int[] nums, int k) {
        //prefixSum[i] represents sum of nums[0..i-1]
        int[] prefixSum = new int[nums.length + 1];
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

    /**
     * <a href="https://leetcode.com/problems/binary-subarrays-with-sum/solution/">Two-pass prefix sum</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Map<Integer, Integer> count = new HashMap();
        int ans = 0;
        //For each j, let's count the number of i with prefixSum[j] = prefixSum[i] + k
        for (int s : prefixSum) {
            ans += count.getOrDefault(s, 0);
            count.put(s + k, count.getOrDefault(s + k, 0) + 1);
        }
        return ans;
    }

    /**
     * One-pass prefix sum
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum3(int[] nums, int k) {
        int cnt = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            sum += num;
            cnt += map.getOrDefault(sum - k, 0);
            if (sum == k) {
                cnt++;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }

    /**
     * <a href="https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-%2B-HashMap">Optimized one-pass
     * prefix sum</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum4(int[] nums, int k) {
        int cnt = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //base case
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            cnt += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
