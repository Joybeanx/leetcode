
package com.joybean.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/">Generate Parentheses</a>
 *
 * @author Joybean
 */
public class GenerateParentheses {

    /*
    //wrong solution, cannot generate:"(())(())" when n = 4
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
     * Iterative(bottom-up) DP
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
     * <a href="https://leetcode.com/problems/generate-parentheses/discuss/10127/An-iterative-method.">Optimized
     * iterative(bottom-up) DP</a>
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
     * backtracking
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis3(int n) {
        List<String> ans = new ArrayList<>();
        backtrack1("", n, n, ans);
        return ans;
    }

    private static void backtrack1(String curPath, int availableOpen, int availableClose,
                                   List<String> ans) {
        if (availableOpen < 0 || availableClose < 0 || availableOpen > availableClose) {
            return;
        }
        if (availableOpen == 0 && availableClose == 0) {
            ans.add(curPath);
            return;
        }
        backtrack1(curPath + "(", availableOpen - 1, availableClose, ans);
        backtrack1(curPath + ")", availableOpen, availableClose - 1, ans);
    }


    /**
     * backtracking
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis4(int n) {
        List<String> ans = new ArrayList<>();
        backtrack2("", 0, 0, n, ans);
        return ans;
    }

    private void backtrack2(String curPath, int open, int close, int n, List<String> ans) {
        if (curPath.length() == 2 * n) {
            ans.add(curPath);
            return;
        }
        if (open < close) {
            return;
        }
        if (open < n) {
            backtrack2(curPath + "(", open + 1, close, n, ans);
        }
        if (close < n) {
            backtrack2(curPath + ")", open, close + 1, n, ans);
        }
    }

    /**
     * backtracking: keep track of available parentheses (by labuladong)
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis5(int n) {
        List<String> ans = new ArrayList<>();
        backtrack3("(", n - 1, n, ans);
        return ans;
    }

    private static void backtrack3(String curPath, int availableOpen, int availableClose, List<String> ans) {
        if (availableOpen == 0 && availableClose == 0) {
            ans.add(curPath);
            return;
        }
        if (availableOpen > availableClose) {
            return;
        }
        if (availableOpen > 0) {
            backtrack3(curPath + "(", availableOpen - 1, availableClose, ans);
        }
        if (availableClose > 0) {
            backtrack3(curPath + ")", availableOpen, availableClose - 1, ans);
        }
    }

    /**
     * <a href="https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking
     * -solution">Optimized backtracking</a>
     * <p>
     * (0, 0, '')
     * |
     * (1, 0, '(')
     * /           \
     * (2, 0, '((')      (1, 1, '()')
     * /                 \
     * (2, 1, '(()')           (2, 1, '()(')
     * /                       \
     * (2, 2, '(())')                (2, 2, '()()')
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis6(int n) {
        List<String> ans = new ArrayList<>();
        backtrack4(new StringBuilder(), 0, 0, n, ans);
        return ans;
    }

    private static void backtrack4(StringBuilder curPath, int open, int close, int n, List<String> ans) {
        if (curPath.length() == 2 * n) {
            ans.add(curPath.toString());
            return;
        }
        if (open < n) {
            curPath.append("(");
            backtrack4(curPath, open + 1, close, n, ans);
            curPath.deleteCharAt(curPath.length() - 1);
        }
        if (open > close) {
            curPath.append(")");
            backtrack4(curPath, open, close + 1, n, ans);
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
    public static List<String> generateParenthesis7(int n) {
        return null;
    }


}
