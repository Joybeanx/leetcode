package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string/">Reverse Words in a String</a>
 *
 * @author Joybean
 */
public class ReverseWordsInAString {
    /**
     * Two pointers
     *
     * @param s
     */
    public static String reverseWords1(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        reverse1(chars, 0, n - 1);
        int start = 0;
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c == ' ') {
                reverse1(chars, start, i - 1);
                start = i + 1;
            }
        }
        reverse1(chars, start, n - 1);
        return squash(chars);

    }

    private static void reverse1(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    private static String squash(char[] chars) {
        int n = chars.length;
        int i = 0;
        int j = n - 1;
        //trim leading spaces
        while (i < n && chars[i] == ' ') {
            i++;
        }
        //trim trailing spaces
        while (j >= 0 && chars[j] == ' ') {
            j--;
        }
        //convert multiple spaces between words to single space
        int cur = 0;
        boolean firstSpace = true;
        while (i <= j) {
            if (chars[i] == ' ' && firstSpace) {
                chars[cur++] = chars[i];
                firstSpace = false;
            } else if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                firstSpace = true;
            }
            i++;
        }
        return new String(chars).substring(0, cur);
    }
}
