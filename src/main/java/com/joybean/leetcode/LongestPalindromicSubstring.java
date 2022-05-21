package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">Longest Palindromic Substring</a>
 *
 * @author Joybean
 */
public class LongestPalindromicSubstring {

    /**
     * DP
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        int n = s.length();
        //dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        int maxLen = 1;
        int startIdx = 0;
        int endIdx = 0;
        for (int j = 1; j < n; j++) {
            dp[j][j] = true;
            for (int i = j - 1; i >= 0; i--) {
                if ((i == j - 1 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        startIdx = i;
                        endIdx = j;
                    }
                }

            }
        }
        return s.substring(startIdx, endIdx + 1);
    }

    /**
     * <a href="https://leetcode.com/problems/longest-palindromic-substring/discuss/2921/Share-my-Java-solution-using
     * -dynamic-programming">Concise DP</a>
     * TODO
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        return null;
    }

    /**
     * Two pointers
     *
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s) {
        return null;
    }

    /**
     * Manacher's algorithm
     * TODO
     *
     * @param s
     * @return
     */
    public static String longestPalindrome4(String s) {
        return null;
    }
}
