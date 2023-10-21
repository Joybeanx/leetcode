package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-ideal-subsequence/">Longest Ideal Subsequence</a>
 *
 * @author Joybean
 */
public class LongestIdealSubsequence {
    /**
     * Iterative(bottom-up) DP:Time Limit Exceeded
     *
     * @param s
     * @param k
     * @return
     */
    public static int longestIdealString1(String s, int k) {
        //dp[i] represents length of the longest ideal string ends with position i
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (Math.abs(s.charAt(i) - s.charAt(j)) <= k) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/longest-ideal-subsequence/solutions/2390471/dp/">Optimized iterative
     * (bottom-up) DP</a>
     *
     * @param s
     * @param k
     * @return
     */
    public static int longestIdealString2(String s, int k) {
        //dp[i] represents length of the longest ideal string ends with character whose alphabet index is i
        int[] dp = new int[26];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            int max = 0;
            for (int j = Math.max(a - k, 0); j <= Math.min(a + k, 25); j++) {
                //instead of: dp[a] = Math.max(dp[j]+1, dp[a])
                dp[a] = Math.max(dp[j], max);
            }
            dp[a] = max + 1;
            ans = Math.max(dp[a], ans);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/longest-ideal-subsequence/solutions/2390512/java-c-python-dp-solution/">
     * Optimized iterative (bottom-up) DP</a>
     * TODO
     *
     * @param s
     * @param k
     * @return
     */
    public static int longestIdealString3(String s, int k) {
        return 0;
    }
}
