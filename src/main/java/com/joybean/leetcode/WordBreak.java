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
     * <a href ="https://leetcode.com/problems/word-break/discuss/169383/solved-The-Time-Complexity-of-The-Brute-Force-Method
     * -Should-Be-O(2n)-and-Prove-It-Below"> Brute Force </a>
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return wb(s, set);
    }

    private static boolean wb(String s, Set<String> set) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i = 1; i <= len; ++i) {
            if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
}
