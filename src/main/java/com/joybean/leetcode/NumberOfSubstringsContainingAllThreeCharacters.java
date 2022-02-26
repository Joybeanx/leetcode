package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/">Number of Substrings
 * Containing All Three Characters</a>
 *
 * @author Joybean
 */
public class NumberOfSubstringsContainingAllThreeCharacters {
    /**
     * Sliding window
     *
     * @param s
     * @return
     */
    public static int numberOfSubstrings1(String s) {
        int left = 0;
        int ans = 0;
        Map<Character, Integer> counter = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            counter.merge(s.charAt(right), 1, Integer::sum);
            while (counter.size() == 3) {
                counter.merge(s.charAt(left), -1, Integer::sum);
                counter.remove(s.charAt(left++), 0);
            }
            ans += left;
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516977
     * /JavaC%2B%2BPython-Easy-and-Concise>Sliding window 2</a>
     *
     * @param s
     * @return
     */
    public static int numberOfSubstrings2(String s) {
        int left = 0;
        int ans = 0;
        int[] counter = new int[3];
        for (int right = 0; right < s.length(); right++) {
            counter[s.charAt(right) - 'a']++;
            while (counter[0] > 0 && counter[1] > 0 && counter[2] > 0) {
                counter[s.charAt(left++) - 'a']--;
            }
            ans += left;
        }
        return ans;
    }
}
