package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/score-of-parentheses/">Score of Parentheses</a>
 *
 * @author joybean
 */
public class ScoreOfParentheses {
    /**
     * Stack solution
     *
     * @param s
     * @return
     */
    public static int scoreOfParentheses1(String s) {
        int ans = 0;
        //stack element stores char index and score
        Deque<int[]> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || stack.isEmpty()) {
                stack.push(new int[] {i, 0});
                continue;
            }
            if (i - stack.peek()[0] == 1) {
                if (stack.size() == 1) {
                    ans += stack.pop()[1] + 1;
                } else {
                    stack.pop();
                    stack.peek()[1] += 1;
                }
            } else {
                if (stack.size() == 1) {
                    ans += 2 * stack.pop()[1];
                } else {
                    int score = stack.pop()[1] * 2;
                    stack.peek()[1] += score;
                }
            }
        }
        return ans;
    }

    /**
     * Stack solution:using sentinel
     *
     * @param s
     * @return
     */
    public static int scoreOfParentheses2(String s) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] {-1, 0});
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || stack.peek()[0] == -1) {
                stack.push(new int[] {i, 0});
                continue;
            }
            if (i - stack.peek()[0] == 1) {
                stack.pop();
                stack.peek()[1] += 1;
            } else {
                int score = stack.pop()[1] * 2;
                stack.peek()[1] += score;
            }
        }
        return stack.peek()[1];
    }

    /**
     * <a href="https://leetcode.com/problems/score-of-parentheses/discuss/141777/C%2B%2BJavaPython-O(1)-Space">Concise
     * stack solution</a>
     *
     * @param s
     * @return
     */
    public static int scoreOfParentheses3(String s) {
        int cur = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(2 * cur, 1);
            }
        }
        return cur;
    }

    /**
     * Array solution
     * TODO
     *
     * @param s
     * @return
     */
    public static int scoreOfParentheses4(String s) {
        return 0;
    }

    /**
     * O(1) spance
     * TODO
     *
     * @param s
     * @return
     */
    public static int scoreOfParentheses5(String s) {
        return 0;
    }
}
