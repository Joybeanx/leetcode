package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/">Generate Parentheses</a>
 *
 * @author Joybean
 */
public class GenerateParentheses {
    /**
     * Ugly DP
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis1(int n) {
        Set<String>[] dp = new Set[n + 1];
        Set<String> first = new HashSet<>();
        first.add("");
        dp[0] = first;
        for (int i = 1; i <= n; i++) {
            Set<String> set = new HashSet<>();
            for (String pre : dp[i - 1]) {
                set.add("(" + pre + ")");
            }
            for (int m = 1; m < i; m++) {
                for (String p1 : dp[m]) {
                    for (String p2 : dp[i - m]) {
                        set.add(p1 + p2);
                        set.add(p2 + p1);
                    }
                }
            }
            dp[i] = set;
        }
        return new ArrayList<>(dp[n]);
    }

    /**
     * <a href="https://leetcode.com/problems/generate-parentheses/discuss/10127/An-iterative-method.">Better DP</a>
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis2(int n) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));
        for (int i = 1; i <= n; ++i) {
            final List<String> list = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                for (final String first : lists.get(j)) {
                    for (final String second : lists.get(i - 1 - j)) {
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            lists.add(list);
        }
        return lists.get(lists.size() - 1);
    }

    /**
     * Backtracking
     * TODO
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis3(int n) {
        return null;
    }
}
