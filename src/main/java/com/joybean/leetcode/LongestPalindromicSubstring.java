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
        int targetStartIdx = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int k = i;
            while (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)) {
                i++;
            }
            int right = i + 1;
            int left = k - 1;
            while (right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
                right++;
                left--;
            }
            int length = right - left - 1;
            if (length > maxLen) {
                maxLen = length;
                targetStartIdx = left + 1;
            }
        }
        return s.substring(targetStartIdx, targetStartIdx + maxLen);
    }

    /**
     * <a
     * href="https://leetcode.com/problems/longest-palindromic-substring/solutions/151144/bottom-up-dp-two-pointers/">
     * Optimized two pointers</a>
     *
     * @param s
     * @return
     */
    public static String longestPalindrome4(String s) {
        int targetStartIdx = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int right = i + 1;
            int skipped = 0;
            while (right < s.length() && s.charAt(i) == s.charAt(right)) {
                right++;
                skipped++;
            }
            int left = i - 1;
            while (right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
                right++;
                left--;
            }
            int length = right - left - 1;
            if (length > maxLen) {
                maxLen = length;
                targetStartIdx = left + 1;
            }
            i += skipped;
        }
        return s.substring(targetStartIdx, targetStartIdx + maxLen);
    }

    /**
     * Manacher's algorithm
     * TODO
     *
     * @param s
     * @return
     */
    public static String longestPalindrome5(String s) {
        return null;
    }
}
