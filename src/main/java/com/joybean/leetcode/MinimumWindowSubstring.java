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
     * <a href="https://leetcode.com/problems/minimum-window-substring/solution/">Sliding window: window counter + target counter</a>
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
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        //number of characters that counter[c] >= number of c in t
        int valid = 0;
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
                        if (right - left + 1 < minLen) {
                            minLeft = left;
                            minLen = right - left + 1;
                        }
                    }
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    /**
     * Sliding window: required target counter
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow3(String s, String t) {
        int n = s.length();
        Map<Character, Integer> requiredCounter = new HashMap<>();
        for (char c : t.toCharArray()) {
            requiredCounter.put(c, requiredCounter.getOrDefault(c, 0) + 1);
        }
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        //number of characters that counter[c] >= number of c in t
        int valid = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (requiredCounter.containsKey(c)) {
                requiredCounter.put(c, requiredCounter.get(c) - 1);
                if (requiredCounter.get(c) == 0) {
                    valid++;
                }
            }
            while (valid == requiredCounter.size()) {
                char lc = s.charAt(left);
                if (requiredCounter.containsKey(lc)) {
                    requiredCounter.put(lc, requiredCounter.get(lc) + 1);
                    if (requiredCounter.get(lc) == 1) {
                        if (right - left + 1 < minLen) {
                            minLeft = left;
                            minLen = right - left + 1;
                        }
                        valid--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    /**
     * Sliding window using Map: keep track of number of characters found in t
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow4(String s, String t) {
        Map<Character, Integer> requiredCounter = new HashMap<>();
        for (char c : t.toCharArray()) {
            requiredCounter.merge(c, 1, Integer::sum);
        }
        int left = 0;
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        //number of characters found in t
        int matched = 0;
        for (int right = 0; right < s.length(); right++) {
            if (requiredCounter.containsKey(s.charAt(right))) {
                requiredCounter.merge(s.charAt(right), -1, Integer::sum);
                if (requiredCounter.get(s.charAt(right)) >= 0) {
                    matched++;
                }
                while (matched == t.length()) {
                    if (requiredCounter.containsKey(s.charAt(left))) {
                        requiredCounter.merge(s.charAt(left), 1, Integer::sum);
                        if (requiredCounter.get(s.charAt(left)) > 0) {
                            if (right - left + 1 < minLen) {
                                minLeft = left;
                                minLen = right - left + 1;
                            }
                            matched--;
                        }
                    }
                    left++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    /**
     * Sliding window using array: keep track of number of characters found in t
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow5(String s, String t) {
        int[] requiredCounter = new int[128];
        for (char c : t.toCharArray()) {
            requiredCounter[c - 'A']++;
        }

        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minLength = Integer.MAX_VALUE;
        //number of characters found in t
        int matched = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            requiredCounter[c - 'A']--;
            //should not change matched if character is not in t
            if (requiredCounter[c - 'A'] >= 0) {
                matched++;
            }
            while (matched == t.length()) {
                char lc = s.charAt(left);
                requiredCounter[lc - 'A']++;
                if (requiredCounter[lc - 'A'] > 0) {
                    if (right - left + 1 < minLength) {
                        minLeft = left;
                        minLength = right - left + 1;
                    }
                    matched--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }


    /**
     * <a href="https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that
     * -can-solve-most-'substring'-problems">Sliding window using array</a>
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow6(String s, String t) {
        int[] requiredCounter = new int[128];
        for (char c : t.toCharArray()) {
            requiredCounter[c]++;
        }
        int left = 0;
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        //number of characters of t to be found in s
        int remainingChars = t.length();
        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            requiredCounter[rc]--;
            //should not change remainingChars if character is not in t
            if (requiredCounter[rc] >= 0) {
                remainingChars--;
            }
            while (remainingChars == 0) {
                char lc = s.charAt(left);
                requiredCounter[lc]++;
                if (requiredCounter[lc] > 0) {
                    remainingChars++;
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minLeft = left;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

}
