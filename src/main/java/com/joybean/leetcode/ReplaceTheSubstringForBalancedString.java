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
     * Sliding window 1
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
            //We can make s balanced as long as all the counts of characters <= n / 4.
            while (left < s.length() && countMap.values().stream().allMatch(each -> each <= expectedCnt)) {
                ans = Math.min(right - left + 1, ans);
                countMap.merge(s.charAt(left++), 1, Integer::sum);
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/replace-the-substring-for-balanced-string/discuss/408978/JavaC%2B
     * %2BPython-Sliding-Window">Sliding window 2</a>
     *
     * @param s
     * @return
     */
    public static int balancedString2(String s) {
        int[] count = new int[128];
        int n = s.length();
        int ans = s.length();
        int left = 0;
        int k = n / 4;
        for (Character ch : s.toCharArray()) {
            count[ch]++;
        }
        for (int right = 0; right < n; right++) {
            --count[s.charAt(right)];
            while (left < n && count['Q'] <= k && count['W'] <= k && count['E'] <= k && count['R'] <= k) {
                ans = Math.min(right - left + 1, ans);
                ++count[s.charAt(left++)];
            }
        }
        return ans;
    }
}
