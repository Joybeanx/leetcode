package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string-ii/">Reverse Words in a String II</a>
 *
 * @author Joybean
 */
public class ReverseWordsInAStringII {
    /**
     * <a href="https://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/">Two pointers</a>
     *
     * @param s
     */
    public static void reverseWords1(char[] s) {
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                //reverse every word except the last word
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        //reverse the last word
        reverse(s, start, s.length - 1);
        //reverse the whole string
        reverse(s, 0, s.length - 1);
    }

    private static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
