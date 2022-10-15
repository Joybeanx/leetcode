package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/largest-divisible-subset/">Largest Divisible Subset</a>
 *
 * @author Joybean
 */
public class LargestDivisibleSubset {
    /**
     * Iterative(bottom-up) DP,concise but inefficient considering space
     *
     * @param nums
     * @return
     */
    public static List<Integer> largestDivisibleSubset1(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        List[] dp = new List[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList();
            dp[i].add(nums[i]);
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j].size() + 1 > dp[i].size()) {
                        dp[i] = new ArrayList(dp[j]);
                        dp[i].add(nums[i]);
                    }
                }
            }
            if (dp[i].size() > ans.size()) {
                ans = dp[i];
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/largest-divisible-subset/discuss/1578933/Java-or-Reuse-Longest-Increasing-Subsequence">Optimized iterative(bottom-up) DP</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static List<Integer> largestDivisibleSubset2(int[] nums) {
        return null;
    }
}
