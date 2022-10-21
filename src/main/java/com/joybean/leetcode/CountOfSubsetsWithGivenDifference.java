package com.joybean.leetcode;

/**
 * <a href="https://www.geeksforgeeks.org/count-of-subsets-with-given-difference/">Count of Subsets with Given Difference</a>
 *
 * @author Joybean
 */
public class CountOfSubsetsWithGivenDifference {
    /**
     * <a href="https://leetcode.com/discuss/interview-question/1271034/count-no-of-subsets-with-given-difference-dp">Iterative(bottom-up) DP</a>
     *
     * @param nums
     * @param n
     * @param diff
     * @return
     */
    public static int subsetWithDifference1(int nums[], int n, int diff) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int reqSum = (diff + sum) / 2;
        //Problem reduces to find count of subsets with given sum
        return subsetWithSum(nums, n, reqSum);
    }

    private static int subsetWithSum(int nums[], int n, int sum) {
        //dp[i][j] represents count of subsets in a[0..i-1] with sum of j
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 0; j <= sum; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
