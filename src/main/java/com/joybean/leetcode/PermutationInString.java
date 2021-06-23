package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/permutation-in-string/">Permutation in String</a>
 *
 * @author Joybean
 */
public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> targetMap = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        int required = targetMap.keySet().size();
        Map<Character, Integer> windowMap = new HashMap<>();
        int valid = 0;
        while (right < s2.length()) {
            Character rc = s2.charAt(right);
            if (targetMap.containsKey(rc)) {
                Integer newCnt = windowMap.getOrDefault(rc, 0) + 1;
                windowMap.put(rc, newCnt);
                if (newCnt.equals(targetMap.get(rc))) {
                    valid++;
                }
            }
            if (right - left + 1 == s1.length()) {
                if (valid == required) {
                    return true;
                }
                Character lc = s2.charAt(left);
                if (targetMap.containsKey(lc)) {
                    int count = windowMap.get(lc);
                    windowMap.put(lc, count - 1);
                    if (count == targetMap.get(lc)) {
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
