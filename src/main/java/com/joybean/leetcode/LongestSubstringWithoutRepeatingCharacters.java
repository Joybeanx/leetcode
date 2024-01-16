package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        int left = 0;
        int right = 0;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            Character c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            ans = Math.max(right - left + 1, ans);
            set.add(c);
            right++;
        }
        return ans;
    }

    /**
     * Sliding window 2
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        int ans = 0;
        int left = 0;
        int right = 0;
        //key:current character, value: current index of character
        Map<Character, Integer> map = new HashMap<>();
        //abba
        while (right < s.length()) {
            Character c = s.charAt(right);
            if (map.containsKey(c)) {
                //An example is abba, if we do not do this, at the end a was already in map and will update i, but it
                // should not update it. aka left pointer should always move forward.
                left = Math.max(map.get(c) + 1, left);
            }
            ans = Math.max(right - left + 1, ans);
            map.put(c, right);
            right++;
        }
        return ans;
    }

}
