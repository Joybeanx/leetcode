package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/">Longest Substring with
 * At Most K Distinct Characters</a>
 *
 * @author Joybean
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    /**
     * Sliding window
     *
     * @param s
     * @param k
     * @return
     */
    //https://www.lintcode.com/problem/386/
    public static int lengthOfLongestSubstringKDistinct1(String s, int k) {
        int left = 0;
        int ans = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            countMap.merge(s.charAt(right), 1, Integer::sum);
            while (countMap.size() > k) {
                countMap.merge(s.charAt(left), -1, Integer::sum);
                countMap.remove(s.charAt(left++), 0);
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }
}
