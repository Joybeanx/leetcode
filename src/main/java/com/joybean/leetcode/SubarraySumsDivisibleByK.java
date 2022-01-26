package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k/">Subarray Sums Divisible by K</a>
 *
 * @author Joybean
 */
public class SubarraySumsDivisibleByK {
    /**
     * Straight forward prefix sum:Time Limit Exceeded
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraysDivByK1(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {
                if ((prefixSum[j] - prefixSum[i]) % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/217985/JavaC%2B%2BPython-Prefix-Sum">Optimized
     * prefix sum</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraysDivByK2(int[] nums, int k) {
        int ans = 0;
        //If sum[0, i] % k == sum[0, j] % k, then sum[i + 1, j] is divisible by by k
        int[] remainderFreq = new int[k];
        //remainder = 0
        remainderFreq[0] = 1;
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            //equivalent to: (prefixSum % k + k) % k
            int remainder = Math.floorMod(prefixSum, k);
            ans += remainderFreq[remainder]++;

        }
        return ans;
    }
}
