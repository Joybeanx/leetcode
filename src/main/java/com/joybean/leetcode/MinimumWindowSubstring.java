package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

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
                String tmp = s.substring(left - 1, right);
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

    /**
     * Two HashMap
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            dict.merge(t.charAt(i), 1, Integer::sum);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dict.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            countMap.merge(c, 1, Integer::sum);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dict.containsKey(c) && countMap.get(c).intValue() == dict.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                countMap.put(c, countMap.get(c) - 1);
                if (dict.containsKey(c) && countMap.get(c).intValue() < dict.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    /**
     * One HashMap
     * @param s
     * @param t
     * @return
     */
    public static String minWindow3(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.merge(s.charAt(right), -1, Integer::sum);
                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.merge(s.charAt(left), 1, Integer::sum);
                        if (map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if (minLen > s.length()) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }
}
