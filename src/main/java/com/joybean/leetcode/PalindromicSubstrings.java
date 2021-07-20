package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindromic-substrings/">Palindromic Substrings</a>
 *
 * @author Joybean
 */
public class PalindromicSubstrings {
    /**
     * Iterative(bottom-up) DP using one-dimensional array
     *
     * @param s
     * @return
     */
    public static int countSubstrings1(String s) {
        //dp[i] represents palindromic substrings length array ends with s[i]
        List<Integer>[] dp = new List[s.length()];
        dp[0] = Collections.singletonList(1);
        int ans = 1;
        for (int i = 1; i < s.length(); i++) {
            List<Integer> pldSubstrLenList = Arrays.asList(1);
            for (int len : dp[i - 1]) {
                if (len == 1) {
                    if (s.charAt(i - 1) == s.charAt(i)) {
                        pldSubstrLenList.add(len + 1);
                    }
                }
                if (i - 1 - len >= 0 && s.charAt(i - 1 - len) == s.charAt(i)) {
                    pldSubstrLenList.add(len + 2);
                }
            }
            dp[i] = pldSubstrLenList;
            ans += dp[i].size();
        }
        return ans;
    }

    /**
     * Iterative(bottom-up) DP with state compression
     *
     * @param s
     * @return
     */
    public static int countSubstrings2(String s) {
        int ans = 1;
        List<Integer> prev = Collections.singletonList(1);
        for (int i = 1; i < s.length(); i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int len : prev) {
                if (len == 1) {
                    if (s.charAt(i - 1) == s.charAt(i)) {
                        cur.add(len + 1);
                    }
                }
                if (i - 1 - len >= 0 && s.charAt(i - 1 - len) == s.charAt(i)) {
                    cur.add(len + 2);
                }
            }
            prev = cur;
            ans += cur.size();
        }
        return ans;
    }

    /**
     * iterative DP using two-dimensional array
     *
     * <a href="https://leetcode.com/problems/palindromic-substrings/discuss/105707/Java-Python-DP-solution-based-on
     * -longest-palindromic-substring"> based on longest palindromic substring </a>
     *
     * @param s
     * @return
     */
    public static int countSubstrings3(String s) {
        int n = s.length();
        int res = 0;
        //dp[i][j] represents palindromic s[i,j]
        boolean[][] dp = new boolean[n][n];
        //must loop from end to start
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    ++res;
                }
            }
        }
        return res;
    }

    /**
     * Recursive expand solution
     * TODO
     *
     * @param s
     * @return
     */
    public static int countSubstrings4(String s) {
        return 0;
    }
}
