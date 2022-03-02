package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">Longest Substring
 * Without Repeating Characters</a>
 *
 * @author Joybean
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Time Limit Exceeded
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        char[] arr = s.toCharArray();
        int length = 0;
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < arr.length; i++) {
            Character c = arr[i];
            if (list.contains(c)) {
                length = Math.max(list.size(), length);
                list = list.subList(list.indexOf(c) + 1, list.size());
            }
            list.add(c);
            if (i == arr.length - 1) {
                length = Math.max(list.size(), length);
            }
        }
        return length;
    }

    /**
     * Sliding window 1
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            Character current = s.charAt(right);
            /**
             *  equivalent to:
             *  if (map.containsKey(current)) {
             *    left = Math.max(map.get(current)+1, left);
             *  }
             */
            while (map.containsKey(current)) {
                map.remove(s.charAt(left));
                left++;
            }
            result = Math.max(right - left + 1, result);
            map.put(current, right);
            right++;
        }
        return result;
    }

    /**
     * Sliding window 2
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int right = 0, left = 0; right < n; right++) {
            if (map.containsKey(s.charAt(right))) {
                //An example is abba, if we do not do this, at the end a was already in map and will update i, but it
                // should not update it. aka left pointer should always move forward.
                left = Math.max(map.get(s.charAt(right)), left);
            }
            ans = Math.max(ans, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return ans;
    }

}
