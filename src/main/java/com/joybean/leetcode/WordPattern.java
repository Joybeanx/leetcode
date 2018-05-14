package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * <a href="https://leetcode.com/problems/word-pattern/description/">Word Pattern</a>
 *
 * @author Jobean
 */
public class WordPattern {

    public static boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] items = str.split(" ");
        if (pattern.length() != items.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(items[i])) {
                    return false;
                }
            } else {
                //ensure an item only match one pattern element
                if (map.containsValue(items[i])) {
                    return false;
                }
                map.put(c, items[i]);
            }
        }
        return true;
    }
}
