package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/remove-k-digits/">Remove K Digits</a>
 *
 * @author Joybean
 */
public class RemoveKDigits {
    /**
     * Monotonic stack
     *
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits1(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > ch && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        //case like "1111" or "1234"
        while (k-- > 0) {
            stack.pop();
        }

        //trim leading zeros
        while (!stack.isEmpty() && stack.peekLast() == '0') {
            stack.pollLast();
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        String ans = sb.toString();
        if (ans.isEmpty()) {
            return "0";
        }
        return ans;
    }
}
