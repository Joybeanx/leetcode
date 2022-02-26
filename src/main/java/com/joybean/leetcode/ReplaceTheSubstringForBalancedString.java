package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/replace-the-substring-for-balanced-string/">Replace the Substring for Balanced
 * String</a>
 *
 * @author Joybean
 */
public class ReplaceTheSubstringForBalancedString {
    /**
     * <a href="https://leetcode.com/problems/replace-the-substring-for-balanced-string/discuss/408978/JavaC%2B
     * %2BPython-Sliding-Window">Sliding window</a>
     *
     * @param s
     * @return
     */
    public static int balancedString1(String s) {
        //count of characters outside the current window
        Map<Character, Integer> countMap = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            countMap.merge(ch, 1, Integer::sum);
        }
        int left = 0;
        int expectedCnt = s.length() / 4;
        int ans = s.length();
        for (int right = 0; right < s.length(); right++) {
            countMap.merge(s.charAt(right), -1, Integer::sum);
            //We can make s balanced as long as max(count[Q],count[W],count[E],count[R]) <= n / 4.
            while (left < s.length() && countMap.values().stream().allMatch(each -> each <= expectedCnt)) {
                ans = Math.min(right - left + 1, ans);
                countMap.merge(s.charAt(left++), 1, Integer::sum);
            }
        }
        return ans;
    }
}
