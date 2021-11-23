package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/remove-duplicate-letters/">Remove Duplicate Letters</a>
 *
 * @author Joybean
 */
public class RemoveDuplicateLetters {
    /**
     * <a href="https://leetcode.com/problems/remove-duplicate-letters/discuss/76769/Java-solution-using-Stack-with
     * -comments">Monotonic stack</a>
     *
     * @param s
     * @return
     */
    public static String removeDuplicateLetters1(String s) {
        char[] chars = s.toCharArray();
        int[] remainingCnt = new int[26];
        for (char ch : chars) {
            remainingCnt[ch - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] inStack = new boolean[26];
        for (char ch : chars) {
            int index = ch - 'a';
            remainingCnt[index]--;
            if (inStack[index]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > ch && remainingCnt[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            inStack[index] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    /**
     * Recursive solution
     *
     * @param s
     * @return
     */
    public static String removeDuplicateLetters2(String s) {
        return null;
    }
}
