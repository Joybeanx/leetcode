package com.joybean.leetcode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/longest-valid-parentheses/">Longest Valid Parentheses</a>
 *
 * @author Joybean
 */
public class LongestValidParentheses {
    /**
     * Iterative(bottom-up) DP
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses1(String s) {
        //dp[i] represents the longest valid parentheses number ends with i
        int[] dp = new int[s.length()];
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i - 1 >= dp[i - 1] && s.charAt(i - 1 - dp[i - 1]) == '(') {
                dp[i] = dp[i - 1] + 2;
                //We also need to add the length of the valid substring just before the term "(,sub_s,)",case:()(())
                if (i > dp[i] && dp[i - dp[i]] > 0) {
                    dp[i] += dp[i - dp[i]];
                }
                ans = Math.max(ans, dp[i]);
            } else if (i + 1 < dp.length && s.charAt(i + 1) == ')' && s.charAt(i) == '(') {
                dp[i + 1] = dp[i - 1] + 2;
                ans = Math.max(ans, dp[i + 1]);
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/longest-valid-parentheses/solution/">Iterative(bottom-up) DP</a>
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses2(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    /**
     * Stack + array
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses3(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                arr[stack.pop()] = 1;
                arr[i] = 1;
            } else {
                stack.push(i);
            }
        }
        //find the longest substring that all items are 1
        int ans = 0;
        int streak = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                streak++;
                ans = Math.max(streak, ans);
            } else {
                streak = 0;
            }
        }
        return ans;
    }


    /**
     * Stack
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        //use -1 as bottom of stack
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == ')') {
                if (stack.peek() != -1 && s.charAt(stack.peek()) == ')') {
                    ans = Math.max(i - stack.pop(), ans);
                } else {
                    stack.push(i);
                }
            } else {
                stack.push(i);
            }
        }
        return ans;
    }

    /**
     * Stack
     *
     * @param s
     * @return
     */
    public int longestValidParentheses4(String s) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        //use -1 as bottom of stack
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.peek() >= 0 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                ans = Math.max(i - stack.peek(), ans);
            } else {
                stack.push(i);
            }
        }
        return ans;
    }
}
