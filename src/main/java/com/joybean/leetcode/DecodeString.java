package com.joybean.leetcode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/decode-string/description/">Decode String</a>
 *
 * @author Joybean
 */
public class DecodeString {
    /**
     * Stack solution
     *
     * @param s
     * @return
     */
    public static String decodeString1(String s) {
        Stack<Object> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == ']') {
                String seg = "";
                while (!stack.isEmpty() && !stack.peek().equals('[')) {
                    seg = stack.pop() + seg;
                }
                stack.pop();
                String num = "";
                while (!stack.isEmpty() && stack.peek() instanceof Character && (Character)stack.peek() >= '0'
                    && (Character)stack.peek() <= '9') {
                    num = stack.pop() + num;
                }
                int repeat = Integer.valueOf(num);
                String parsed = "";
                for (int i = 0; i < repeat; i++) {
                    parsed += seg;
                }
                stack.push(parsed);
            } else {
                stack.push(c);
            }
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
