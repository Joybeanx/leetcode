package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/largest-sum-of-averages/">Largest Sum of Averages</a>
 *
 * @author Joybean
 */
public class LargestSumOfAverages {
    /**
     * Iterative(bottom-up) DP
     *
     * @param nums
     * @param k
     * @return
     */
    public static double largestSumOfAverages1(int[] nums, int k) {
        double ans = 0;
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        //dp[i][j] represents maximum score of nums[0..i-1] with j partitions
        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = (double) preSum[i] / i;
            for (int j = 2; j <= Math.min(i, k); j++) {
                for (int m = 0; m < i; m++) {
                    dp[i][j] = Math.max(dp[m][j - 1] + (double) (preSum[i] - preSum[m]) / (i - m), dp[i][j]);
                }
            }
        }
        for (int j = 1; j <= k; j++) {
            ans = Math.max(dp[n][j], ans);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/largest-sum-of-averages/solutions/127512/largest-sum-of-averages/">Optimized iterative(bottom-up) DP</a>
     * TODO
     *
     * @param nums
     * @param k
     * @return
     */
    public static double largestSumOfAverages2(int[] nums, int k) {
        return 0;
    }


    /*public static double largestSumOfAverages3(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        //dp[i] represents maximum score of nums[0..i-1] with at most s partitions (the most outer loop variant)
        double[] dp = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int s = 1; s <= k; s++) {
            for (int i = 1; i <= n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    //May exceed partition limit
                    dp[i] = Math.max(dp[j] + (double) (preSum[i] - preSum[j]) / (i - j), dp[i]);
                }
            }
        }
        return dp[n];
    }*/
}
