package com.joybean.leetcode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/basic-calculator/">Basic Calculator</a>
 *
 * @author Joybean
 */
public class BasicCalculator {
    /**
     * <a href="https://leetcode.com/problems/basic-calculator/solutions/62361/iterative-java-solution-with-stack/">Iterative solution with stack</a>
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
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
}
