package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/remove-invalid-parentheses/">Remove Invalid Parentheses</a>
 *
 * @author Joybean
 */
public class RemoveInvalidParentheses {
    /**
     * Straight forward DFS
     * @param s
     * @return
     */
    public static List<String> removeInvalidParentheses1(String s) {
        int open = 0;
        int removeCnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (--open < 0) {
                    open = 0;
                    removeCnt++;
                }

            }
        }
        removeCnt += open;

        Set<String> ans = removeInvalidParentheses(s, removeCnt, new HashMap<>());
        return new ArrayList<>(ans);
    }

    private static Set<String> removeInvalidParentheses(String s, int k, Map<String, Set<String>> memo) {
        if (memo.containsKey(s + k)) {
            return memo.get(s + k);
        }
        Set<String> ans = new HashSet<>();
        if (k == 0) {
            if (isValid(s)) {
                ans.add(s);
            }
            return ans;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                continue;
            }
            if (i != 0 && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            String nextStr = s.substring(0, i) + s.substring(i + 1);
            Set<String> valid = removeInvalidParentheses(nextStr, k - 1, memo);
            ans.addAll(valid);
            memo.put(nextStr + (k - 1), valid);
        }
        return ans;
    }

    private static boolean isValid(String s) {
        int open = 0;
        int close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                close++;
                if (close > open) {
                    return false;
                }
            }
        }
        return open == close;
    }

    /**
     * <a
     * href="https://leetcode.com/problems/remove-invalid-parentheses/solutions/75027/easy-short-concise-and-fast-java-dfs-3-ms-solution/?orderBy=most_votes">DFS
     * solution</a>
     * TODO
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        return null;
    }
}
