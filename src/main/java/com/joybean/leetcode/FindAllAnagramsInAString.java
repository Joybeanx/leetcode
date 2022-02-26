package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">Find All Anagrams in a String</a>
 *
 * @author Joybean
 */
public class FindAllAnagramsInAString {
    /**
     * Sliding window
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams1(String s, String p) {
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Integer> dict = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (Character c : p.toCharArray()) {
            dict.merge(c, 1, Integer::sum);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s.length() ) {
            Character rc = s.charAt(right);
            if (dict.containsKey(rc)) {
                counter.put(rc, counter.getOrDefault(rc, 0) + 1);
                if (dict.get(rc).equals(counter.get(rc))) {
                    valid++;
                }
            }
            if (right - left + 1 == p.length()) {
                if (valid == dict.size()) {
                    res.add(left);
                }
                Character lc = s.charAt(left);
                left++;
                if (dict.containsKey(lc)) {
                    if (counter.get(lc).equals(dict.get(lc))) {
                        valid--;
                    }
                    counter.merge(lc, -1, Integer::sum);
                }
            }
            right++;
        }
        return res;
    }
}
