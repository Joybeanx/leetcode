package com.joybean.leetcode;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/minimum-window-substring/">Minimum Window Substring</a>
 *
 * @author Joybean
 */
public class MinimumWindowSubstring {
    /**
     * Time Limit Exceeded
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow1(String s, String t) {
        int left = 0;
        int right = 0;
        String minWindow = "";
        while (right != s.length()) {
            right++;
            boolean f = false;
            while (exist(s, t, left, right)) {
                left++;
                f = true;
            }
            if (f) {
                left--;
                String tmp = s.substring(left, right);
                minWindow = tmp.length() > minWindow.length() && !"".equals(minWindow) ? minWindow : tmp;
            }
        }
        return minWindow;
    }

    public static boolean exist(String source, String target, int left, int right) {
        char[] windowChars = new char[right - left];
        source.getChars(left, right, windowChars, 0);
        StringBuilder window = new StringBuilder(new String(windowChars));
        f:
        for (char tc : target.toCharArray()) {
            int i = 0;
            for (char wc : window.toString().toCharArray()) {
                if (wc == tc) {
                    window.deleteCharAt(i);
                    continue f;
                }
                i++;
            }
            return false;
        }
        return true;
    }
}
