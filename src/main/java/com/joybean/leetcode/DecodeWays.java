package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/decode-ways/">Decode Ways</a>
 *
 * @author Joybean
 */
public class DecodeWays {
    /**
     * Iterative(bottom-up) DP
     *
     * @param s
     * @return
     */
    public static int numDecodings1(String s) {
        //dp[i] represents decoding ways of s[0,i-1]
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            char cur1 = s.charAt(i - 1);
            if (cur1 >= '1' && cur1 <= '9') {
                dp[i] = dp[i - 1];
            }
            if (i < 2) {
                continue;
            }
            int cur2 = Integer.valueOf(s.substring(i - 2, i));
            if (cur2 >= 10 && cur2 <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
