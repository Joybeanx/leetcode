package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-valid-parentheses/">Longest Valid Parentheses</a>
 *
 * @author Joybean
 */
public class LongestValidParentheses {
    /**
     * DP
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses1(String s) {
        //dp[i] represents the longest valid parentheses number ends with i
        int[] dp = new int[s.length()];
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i - 1 >= dp[i - 1] && s.charAt(i - 1 - dp[i - 1]) == '(') {
                dp[i] = dp[i - 1] + 2;
                //We also need to add the length of the valid substring just before the term "(,sub_s,)",case:()(())
                if (i > dp[i] && dp[i - dp[i]] > 0) {
                    dp[i] += dp[i - dp[i]];
                }
                ans = Math.max(ans, dp[i]);
            } else if (i + 1 < dp.length && s.charAt(i + 1) == ')' && s.charAt(i) == '(') {
                dp[i + 1] = dp[i - 1] + 2;
                ans = Math.max(ans, dp[i + 1]);
            }
        }
        return ans;
    }

    /**
     * DP:
     * <a href="https://leetcode.com/problems/longest-valid-parentheses/solution/">More graceful approach</a>
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses2(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    /**
     * Using Stack
     * TODO
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses3(String s) {
        return 0;
    }
}
