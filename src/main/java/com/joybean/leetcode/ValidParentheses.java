package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">Valid Parentheses</a>
 *
 * @author Joybean
 */
public class ValidParentheses {
    /**
     * Straightforward stack solution
     *
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty() || map.get(stack.peek()) != c) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }

    /**
     * <a
     * href="https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution">Concise
     * stack solution</a>
     *
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
