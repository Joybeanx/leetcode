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
        Map<Character, Integer> windowCounts = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            windowCounts.merge(s.charAt(right), 1, Integer::sum);
            while (windowCounts.size() == 3) {
                windowCounts.merge(s.charAt(left), -1, Integer::sum);
                windowCounts.remove(s.charAt(left++), 0);
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
        int[] count = new int[3];
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(left++) - 'a']--;
            }
            ans += left;
        }
        return ans;
    }
}
