package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/permutation-in-string/">Permutation in String</a>
 *
 * @author Joybean
 */
public class PermutationInString {
    /**
     * Sliding window
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> dict = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            dict.merge(c, 1, Integer::sum);
        }
        int required = dict.keySet().size();
        Map<Character, Integer> countMap = new HashMap<>();
        int valid = 0;
        while (right < s2.length()) {
            Character rc = s2.charAt(right);
            if (dict.containsKey(rc)) {
                countMap.merge(rc, 1, Integer::sum);
                if (countMap.get(rc).equals(dict.get(rc))) {
                    valid++;
                }
            }
            if (right - left + 1 == s1.length()) {
                if (valid == required) {
                    return true;
                }
                Character lc = s2.charAt(left);
                if (dict.containsKey(lc)) {
                    countMap.merge(lc, -1, Integer::sum);
                    if (countMap.get(lc).equals(dict.get(lc))) {
                        valid--;
                    }
                }
                left++;
            }
            right++;
        }
        return false;
    }
}
