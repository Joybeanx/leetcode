package com.joybean.leetcode;

import java.util.Stack;

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
        int n = num.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            Character c = num.charAt(i);
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        //case like "1111" or "1234"
        while (k > 0) {
            stack.pop();
            k--;
        }
        //trim leading zeros
        int i = 0;
        while (i < stack.size() && stack.get(i) == '0') {
            i++;
        }
        String ans = "";
        while (i < stack.size()) {
            ans += stack.get(i++);
        }
        return ans == "" ? "0" : ans;
    }


    /**
     * <a href="https://leetcode.com/problems/remove-k-digits/solutions/629860/java-c-python3-easy-explanation/">Monotonic stack</a>
     *
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits2(String num, int k) {
        int n = num.length();
        if (k == n) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            Character c = num.charAt(i);
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        //case like "1111" or "1234"
        while (k-- > 0) {
            stack.pop();
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        int i = 0;
        //trim leading zeros
        while (i < ans.length() - 1 && ans.charAt(i) == '0') {
            i++;
        }
        return ans.substring(i);
    }

}
