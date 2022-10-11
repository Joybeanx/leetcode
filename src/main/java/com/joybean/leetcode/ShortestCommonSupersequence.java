package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/shortest-common-supersequence/">Shortest Common Supersequence</a>
 *
 * @author Joybean
 */
public class ShortestCommonSupersequence {
    /**
     * <a href="https://leetcode.com/problems/shortest-common-supersequence/discuss/312710/C%2B%2BPython-Find-the-LCS">Iterative(bottom-up) DP(by fightForPuppy)</a>
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String shortestCommonSupersequence1(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        String lcs = longestCommonSubsequence(str1, str2);
        int i = 0;
        int j = 0;
        for (int cur = 0; cur < lcs.length(); cur++, i++, j++) {
            char ch = lcs.charAt(cur);
            while (i < str1.length() && str1.charAt(i) != ch) {
                sb.append(str1.charAt(i++));
            }
            while (j < str2.length() && str2.charAt(j) != ch) {
                sb.append(str2.charAt(j++));
            }
            sb.append(ch);
        }
        sb.append(str1.substring(i)).append(str2.substring(j));
        return sb.toString();
    }

    /**
     * see {@link LongestCommonSubsequence}
     *
     * @param text1
     * @param text2
     * @return
     */
    private static String longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //dp[i][j] stores the longest common subsequence between text1[0..i-1] and text2[0..j-1]
        String[][] dp = new String[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], "");
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + text1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
