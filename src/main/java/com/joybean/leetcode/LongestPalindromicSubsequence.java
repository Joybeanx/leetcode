package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-subsequence/">Longest Palindromic Subsequence</a>
 *
 * @author Joybean
 */
public class LongestPalindromicSubsequence {
    /**
     * Iterative(bottom-up) DP
     *
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq1(String s) {
        int n = s.length();
        //dp[i][j] represents longest palindromic sequence's length of s[i..j]
        int[][] dp = new int[n][n];
        //base case
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * Iterative(bottom-up) DP with state compression
     *
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq2(String s) {
        int n = s.length();
        //dp[j] represents longest palindromic sequence's length of s[0..j]
        int[] dp = new int[n];
        //base case: create a projection by the base case of two-dimensional array
        for (int j = n - 1; j >= 0; j--) {
            dp[j] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                //before update dp[j], dp[j] presents the result of the outer loop
                int tmp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = pre + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = tmp;
            }
        }
        return dp[n - 1];
    }

}
