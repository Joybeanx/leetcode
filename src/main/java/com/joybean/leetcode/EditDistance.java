package com.joybean.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/edit-distance/>Edit Distance</a>
 *
 * @author Joybean
 */
public class EditDistance {
    /**
     * Recursive(top-down) DP
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance1(String word1, String word2) {
        Map<List<String>, Integer> memo = new HashMap<>();
        return minDistanceInternal1(word1, word2, memo);
    }

    public static int minDistanceInternal1(String seg1, String seg2, Map<List<String>, Integer> memo) {
        if (seg2.length() == 0) {
            return seg1.length();
        }
        if (seg1.length() == 0) {
            return seg2.length();
        }
        List<String> key = Arrays.asList(seg1, seg2);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int idx = 0;
        while (seg1.length() > idx && seg2.length() > idx && seg1.charAt(idx) == seg2.charAt(idx)) {
            idx++;
        }
        String rest1 = subStrSafely(seg1, idx);
        String rest2 = subStrSafely(seg2, idx);
        if (rest1.isEmpty() && rest2.isEmpty()) {
            return 0;
        }

        int res = Math.min(minDistanceInternal1(subStrSafely(rest1, 1), rest2, memo),
            minDistanceInternal1(rest1, subStrSafely(rest2, 1), memo));
        res = Math.min(res, minDistanceInternal1(subStrSafely(rest1, 1),
            subStrSafely(rest2, 1), memo)) + 1;
        memo.put(key, res);
        return res;
    }

    private static String subStrSafely(String str, int from) {
        return str.length() > from ? str.substring(from) : "";
    }

    /**
     * Recursive(top-down) DP using two pointers
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance2(String word1, String word2) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return minDistanceInternal2(word1, word2, 0, 0, memo);
    }

    public static int minDistanceInternal2(String word1, String word2, int i, int j, Map<List<Integer>, Integer> memo) {
        if (i == word1.length()) {
            return word2.length() - j;
        }
        if (j == word2.length()) {
            return word1.length() - i;
        }
        List<Integer> key = Arrays.asList(i, j);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return minDistanceInternal2(word1, word2, i + 1, j + 1, memo);
        } else {
            int res = Math.min(minDistanceInternal2(word1, word2, i, j + 1, memo),
                minDistanceInternal2(word1, word2, i + 1, j, memo));
            res = Math.min(res,
                minDistanceInternal2(word1, word2, i + 1, j + 1, memo)) + 1;
            memo.put(key, res);
            return res;
        }
    }

    /**
     * Iterative(bottom-up) DP
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance3(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //offset
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
