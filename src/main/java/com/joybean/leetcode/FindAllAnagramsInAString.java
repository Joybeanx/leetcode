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
        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> needMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (Character c : p.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s.length() ) {
            Character rc = s.charAt(right);
            if (needMap.containsKey(rc)) {
                windowMap.put(rc, windowMap.getOrDefault(rc, 0) + 1);
                if (needMap.get(rc).equals(windowMap.get(rc))) {
                    valid++;
                }
            }
            if (right - left + 1 == p.length()) {
                if (valid == needMap.size()) {
                    res.add(left);
                }
                Character lc = s.charAt(left);
                left++;
                if (needMap.containsKey(lc)) {
                    if (windowMap.get(lc).equals(needMap.get(lc))) {
                        valid--;
                    }
                    windowMap.put(lc, windowMap.getOrDefault(lc, 0) - 1);
                }
            }
            right++;
        }
        return res;
    }
}
