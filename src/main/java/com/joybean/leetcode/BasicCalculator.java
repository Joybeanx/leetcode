package com.joybean.leetcode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/basic-calculator/">Basic Calculator</a>
 *
 * @author Joybean
 */
public class BasicCalculator {

    /**
     * Straight forward: Time Limit Exceeded
     *
     * @param s
     * @return
     */
    public static int calculate1(String s) {
        Stack<String> stack = new Stack<>();
        int ans = 0;
        Integer num = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            Character c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                stack.push(num.toString());
                stack.push(c.toString());
                num = 0;

            } else if (c == '(') {
                stack.push(c.toString());

            } else if (c == ')') {
                stack.push(num.toString());
                num = 0;
                Integer n = 0;
                int k = 0;
                while (!stack.peek().equals("(")) {
                    String popped = stack.pop();
                    if (popped.equals("+")) {
                        n += k;
                    } else if (popped.equals("-")) {
                        n -= k;
                    } else {
                        k = Integer.valueOf(popped);
                        if (stack.peek().equals("(")) {
                            n += k;
                        }
                    }
                }
                stack.pop();
                stack.push(n.toString());
            }
        }
        stack.push(num.toString());
        int k = 0;
        while (!stack.isEmpty()) {
            String popped = stack.pop();
            if (popped.equals("+")) {
                ans += k;
            } else if (popped.equals("-")) {
                ans -= k;
            } else {
                k = Integer.valueOf(popped);
                if (stack.isEmpty()) {
                    ans += k;
                }
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/basic-calculator/solutions/62361/iterative-java-solution-with-stack/">Stack</a>
     *
     * @param s
     * @return
     */
    public static int calculate2(String s) {
        int result = 0;
        int number = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = 10 * number + (c - '0');
            } else if (c == '+') {
                result += number * sign;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += number * sign;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                ///reset the sign and result
                result = 0;
                //case: - (3 + (4 + 5))
                sign = 1;
            } else if (c == ')') {
                result += number * sign;
                //the sign before the parenthesis
                result *= stack.pop();
                //the result calculated before the parenthesis
                result += stack.pop();
                number = 0;
            }
        }
        result += number * sign;
        return result;
    }

    /**
     * <a href="https://leetcode.com/problems/basic-calculator/solutions/62362/java-easy-version-to-understand/">Stack: keeps the most recent sum at the top of stack(by cdai)</a>
     * TODO
     *
     * @param s
     * @return
     */
    public static int calculate3(String s) {
        return 0;
    }
}
