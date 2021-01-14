package com.joybean.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">Longest Substring Without Repeating Characters</a>
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
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        char[] arr = s.toCharArray();
        int length = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < arr.length; i++) {
            Character c = arr[i];
            if (map.containsKey(c) && map.get(c) >= start) {
                length = Math.max(i - start, length);
                start = map.get(c) + 1;
            }
            map.put(c, i);
            if (i == arr.length - 1) {
                length = Math.max(i - start + 1, length);
            }
        }
        return length;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
