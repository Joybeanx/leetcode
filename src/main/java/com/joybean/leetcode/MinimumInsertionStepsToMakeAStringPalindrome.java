package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/">Minimum Insertion
 * Steps to Make a String Palindrome</a>
 *
 * @author Joybean
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {
    /**
     * DP
     *
     * @param s
     * @return
     */
    public static int minInsertions1(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i + 1][j] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * DP with state compression
     *
     * @param s
     * @return
     */
    public static int minInsertions2(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int tmp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = pre;
                } else {
                    dp[j] = Math.min(dp[j - 1] + 1, dp[j] + 1);
                    dp[j] = Math.min(dp[j], pre + 2);
                }
                pre = tmp;
            }
        }
        return dp[n - 1];
    }
}
