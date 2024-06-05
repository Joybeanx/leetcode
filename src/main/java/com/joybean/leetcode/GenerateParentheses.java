
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
     * wrong solution, cannot generate:"(())(())" when n = 4
     *
     * @param n
     * @return
     */
    /*
    public static List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        generateParenthesis(n, "", set);
        return new ArrayList<>(set);
    }

    private static void generateParenthesis(int n, String curPath, Set<String> set) {
        if (n == 0) {
            set.add(curPath);
            return;
        }
        generateParenthesis5(n - 1, "(" + curPath + ")", set);
        generateParenthesis5(n - 1, "()" + curPath, set);
        generateParenthesis5(n - 1, curPath + "()", set);
    }*/

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
     * backtracking (by labuladong)
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis3(int n) {
        List<String> ans = new ArrayList<>();
        backtrack1(n - 1, n, "(", ans);
        return ans;
    }

    private static void backtrack1(int availableOpen, int availableClose, String curPath, List<String> ans) {
        if (availableOpen == 0 && availableClose == 0) {
            ans.add(curPath);
            return;
        }
        if (availableOpen > availableClose) {
            return;
        }
        if (availableOpen > 0) {
            backtrack1(availableOpen - 1, availableClose, curPath + "(", ans);
        }
        if (availableClose > 0) {
            backtrack1(availableOpen, availableClose - 1, curPath + ")", ans);
        }
    }

    /**
     * <a href="https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking
     * -solution">Optimized backtracking</a>
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis4(int n) {
        List<String> ans = new ArrayList<>();
        backtrack2(0, 0, n, new StringBuilder(), ans);
        return ans;
    }

    private static void backtrack2(int open, int close, int n, StringBuilder curPath, List<String> ans) {
        if (curPath.length() == 2 * n) {
            ans.add(curPath.toString());
            return;
        }
        if (open < n) {
            curPath.append("(");
            backtrack2(open + 1, close, n, curPath, ans);
            curPath.deleteCharAt(curPath.length() - 1);
        }
        if (open > close) {
            curPath.append(")");
            backtrack2(open, close + 1, n, curPath, ans);
            curPath.deleteCharAt(curPath.length() - 1);
        }
    }

    /**
     * <a href="https://leetcode.com/problems/generate-parentheses/solution/">Closure Number</a>
     * TODO
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis5(int n) {
        return null;
    }
}
