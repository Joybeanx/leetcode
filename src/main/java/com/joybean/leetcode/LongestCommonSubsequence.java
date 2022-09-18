package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/">Longest Common Subsequence</a>
 *
 * @author Joybean
 */
public class LongestCommonSubsequence {
    /**
     * Iterative(bottom-up) DP
     *
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //dp[i][j] stores the longest common subsequence between text1[0..i-1] and text2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * Iterative(bottom-up) DP with state compression
     *
     * @param text1
     * @param text2
     * @return
     * @see <a href="https://leetcode.com/problems/longest-common-subsequence/discuss/351689/JavaPython-3-Two-DP-codes-of-O(mn)-and-O(min(m-n))-spaces-w-picture-and-analysis">survive's solution</a>
     */
    public static int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //dp[j] stores the longest common subsequence between text1[0..m-1] and text2[0..j-1]
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int cur = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = cur;
            }
        }
        return dp[n];
    }

    /**
     * Recursive(top-down) DP with memo
     * TODO
     *
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence3(String text1, String text2) {
        return 0;
    }
}
