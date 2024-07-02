package com.joybean.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/word-break/">Word Break</a>
 *
 * @author Joybean
 */
public class WordBreak {
    /**
     * Iterative(bottom-up) DP
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }
        //dp[i] represents whether s(0,i-1) can be segmented by word dict
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (String word : wordDict) {
                int wordLength = word.length();
                if (i - 1 + wordLength > s.length()) {
                    continue;
                }
                if (dp[i + wordLength - 1]) {
                    continue;
                }
                //or: dp[i - 1 + wordLength] = dp[i - 1] && s.startsWith(word, i - 1);
                dp[i - 1 + wordLength] = dp[i - 1] && words.contains(s.substring(i - 1, i - 1 + wordLength));
            }
        }
        return dp[s.length()];
    }

    /**
     * <a href ="https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways">
     * Another DP </a>
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (!dp[i] && word.length() <= i) {
                    if (dp[i - word.length()]) {
                        if (s.startsWith(word, i - word.length())) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * Recursive(top-down) DP
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int[] memo = new int[s.length()];
        return wordBreak3(0, s, dict, memo);
    }

    private static boolean wordBreak3(int start, String s, Set<String> dict, int[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] == 1) {
            return true;
        }
        if (memo[start] == -1) {
            return false;
        }
        String word = "";
        for (int i = start; i < s.length(); i++) {
            word += s.charAt(i);
            if (dict.contains(word)) {
                if (wordBreak3(i + 1, s, dict, memo)) {
                    memo[start] = 1;
                    return true;
                }
            }
        }
        memo[start] = -1;
        return false;
    }
}
