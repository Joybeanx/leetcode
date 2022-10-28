package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/delete-operation-for-two-strings/">Delete Operation for Two Strings</a>
 *
 * @author Joybean
 */
public class DeleteOperationForTwoStrings {
    /**
     * Iterative(bottom-up) DP: same idea as {@link EditDistance}
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance1(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //dp[i][j] represent minimum distance between word1[0..i-1] and word2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //equivalent to: Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i - 1][j - 1] + 2)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    /**
     * <a href="https://leetcode.com/problems/delete-operation-for-two-strings/discuss/103214/Java-DP-Solution-(Longest-Common-Subsequence)">Iterative(bottom-up) DP: find LCS</a>
     * //TODO
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance2(String word1, String word2) {
        return 0;
    }
}
