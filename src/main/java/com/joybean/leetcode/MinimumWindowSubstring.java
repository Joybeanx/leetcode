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
     * <a href="https://leetcode.com/problems/minimum-window-substring/solution/">Sliding window using two map</a>
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
        Map<Character, Integer> targetCounter = new HashMap<>();
        for (Character c : t.toCharArray()) {
            targetCounter.put(c, targetCounter.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> windowCounter = new HashMap<>();
        int left = 0;
        int right = 0;
        int valid = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < s.length()) {
            Character c = s.charAt(right);
            if (targetCounter.containsKey(c)) {
                windowCounter.put(c, windowCounter.getOrDefault(c, 0) + 1);
                //should not use windowCounter.get(c)  == targetCounter.get(c)
                //https://leetcode.com/problems/minimum-window-substring/submissions/1339139071/
                if (windowCounter.get(c).intValue() == targetCounter.get(c).intValue()) {
                    valid++;
                }
            }
            while (valid == targetCounter.size()) {
                Character lc = s.charAt(left);
                if (targetCounter.containsKey(lc)) {
                    windowCounter.put(lc, windowCounter.get(lc) - 1);
                    if (windowCounter.get(lc) < targetCounter.get(lc)) {
                        valid--;
                        if (right - left + 1 < minLength) {
                            minStart = left;
                            minLength = right - left + 1;
                        }
                    }
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    /**
     * Sliding window using one map
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow3(String s, String t) {
        Map<Character, Integer> requiredCounter = new HashMap<>();
        for (char c : t.toCharArray()) {
            requiredCounter.merge(c, 1, Integer::sum);
        }
        int left = 0;
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        int formed = 0;
        for (int right = 0; right < s.length(); right++) {
            if (requiredCounter.containsKey(s.charAt(right))) {
                requiredCounter.merge(s.charAt(right), -1, Integer::sum);
                if (requiredCounter.get(s.charAt(right)) >= 0) {
                    formed++;
                }
                while (formed == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (requiredCounter.containsKey(s.charAt(left))) {
                        requiredCounter.merge(s.charAt(left), 1, Integer::sum);
                        if (requiredCounter.get(s.charAt(left)) > 0) {
                            formed--;
                        }
                    }
                    left++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    /**
     * <a href="https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that
     * -can-solve-most-'substring'-problems">Sliding window using array</a>
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow4(String s, String t) {
        int[] requiredCounter = new int[128];
        for (char c : t.toCharArray()) {
            requiredCounter[c]++;
        }
        int left = 0;
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        //Number of characters of t to be found in s.
        int remainingChars = t.length();
        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            requiredCounter[rc]--;
            if (requiredCounter[rc] >= 0) {
                remainingChars--;
            }
            while (remainingChars == 0) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                char lc = s.charAt(left++);
                requiredCounter[lc]++;
                if (requiredCounter[lc] > 0) {
                    remainingChars++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }


}
