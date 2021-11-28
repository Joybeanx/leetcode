package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/">Smallest Subsequence of Distinct
 * Characters</a>
 *
 * @author Joybean
 */
public class SmallestSubsequenceOfDistinctCharacters {
    /**
     * This question is the same as: Remove Duplicate Letters
     * @param s
     * @return
     * @see com.joybean.leetcode.RemoveDuplicateLetters
     */
    public String smallestSubsequence(String s) {
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
}
