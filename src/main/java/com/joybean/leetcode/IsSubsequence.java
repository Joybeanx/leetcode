package com.joybean.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/is-subsequence/">Is Subsequence</a>
 *
 * @author Joybean
 */
public class IsSubsequence {
    /**
     * Straight forward
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence1(String s, String t) {
        //bucket stores indexes of each character in t
        List<Integer>[] buckets = new List[26];
        for (int i = 0; i < 26; i++) {
            buckets[i] = new LinkedList<>();
        }
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            buckets[ch - 'a'].add(i);
        }
        int lastIdx = -1;
        for (Character ch : s.toCharArray()) {
            List<Integer> indexes = buckets[ch - 'a'];
            if (indexes == null || indexes.isEmpty()) {
                return false;
            }
            int k = 0;
            //try to find matched character in t
            //"ab" "baab"
            while (k < indexes.size() && indexes.get(k) < lastIdx) {
                k++;
            }
            if (k == indexes.size()) {
                return false;
            }
            lastIdx = indexes.remove(k);
        }
        return true;
    }

    /**
     * Iterative(bottom-up) DP
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence2(String s, String t) {
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    /**
     * Two pointers
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence3(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (j == t.length()) {
                return false;
            }
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return true;
    }

    /**
     * <a href="https://leetcode.com/problems/is-subsequence/discuss/87254/Straight-forward-Java-simple-solution">Two pointers</a>
     * TODO
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence4(String s, String t) {
        return false;
    }

    /**
     * TODO follow-up
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence5(String s, String t) {
        return false;
    }
}
