package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-subsequence/">Longest Palindromic Subsequence</a>
 *
 * @author Joybean
 */
public class LongestPalindromicSubsequence {
    /**
     * DP
     *
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq1(String s) {
        int n = s.length();
        //dp[i][i] represents longest palindromic sequence's length of s[i..j]
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = 1;
            }
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
     * DP with state compression
     * TODO
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq2(String s) {
        return 1;
    }

}
