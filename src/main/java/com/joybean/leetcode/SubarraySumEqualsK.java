package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/">Subarray Sum Equals K</a>
 *
 * @author Joybean
 */
public class SubarraySumEqualsK {

    /*
    //Wrong solution, can't use dp to solve this problem because k can be negative, failed case: nums=[-1, -1, 1], k=0
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        int ans = 0;
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (i > 1 && j == nums[i - 1]) {
                    dp[i][j] = 1;
                }
                dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
            ans += dp[i][k];
        }
        return ans;
    }
    */

    /**
     * Two-pass prefix sum
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (prefixSum[j] - prefixSum[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * Two-pass prefix sum
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {
        //prefixSum[i] represents sum of nums[0..i-1]
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int ans = 0;
        //Why not use set? Think about this case: [1, -1, 0], 0
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < prefixSum.length; i++) {
            if (counter.containsKey(prefixSum[i] - k)) {
                ans += counter.get(prefixSum[i] - k);
            }
            counter.merge(prefixSum[i], 1, Integer::sum);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/binary-subarrays-with-sum/solution/">Two-pass prefix sum</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum3(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Map<Integer, Integer> counter = new HashMap();
        int ans = 0;
        //For each j, let's count the number of i with prefixSum[j] = prefixSum[i] + k
        for (int s : prefixSum) {
            ans += counter.getOrDefault(s, 0);
            counter.merge(s + k, 1, Integer::sum);
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
    public static int subarraySum4(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            sum += num;
            ans += counter.getOrDefault(sum - k, 0);
            if (sum == k) {
                ans++;
            }
            counter.merge(sum, 1, Integer::sum);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-%2B-HashMap">Optimized one-pass prefix sum</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum5(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        //base case
        counter.put(0, 1);
        for (int num : nums) {
            sum += num;
            ans += counter.getOrDefault(sum - k, 0);
            counter.merge(sum, 1, Integer::sum);
        }
        return ans;
    }






}
