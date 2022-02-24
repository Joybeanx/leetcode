package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/get-equal-substrings-within-budget/">Get Equal Substrings Within Budget</a>
 *
 * @author Joybean
 */
public class GetEqualSubstringsWithinBudget {
    /**
     * Sliding window
     *
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public static int equalSubstring1(String s, String t, int maxCost) {
        int left = 0;
        int sum = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            sum += Math.abs(t.charAt(right) - s.charAt(right));
            while (sum > maxCost) {
                sum -= Math.abs(t.charAt(left) - s.charAt(left++));
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/get-equal-substrings-within-budget/discuss/392837/JavaC%2B%2BPython
     * -Sliding-Window">Optimized sliding window</a>
     *
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public static int equalSubstring2(String s, String t, int maxCost) {
        int left = 0;
        int right = 0;
        int sum = 0;
        for (right = 0; right < s.length(); right++) {
            sum += Math.abs(t.charAt(right) - s.charAt(right));
            if (sum > maxCost) {
                sum -= Math.abs(t.charAt(left) - s.charAt(left++));
            }
            // Possible result (the length of [left,right]) is always increasing, we don't need to do calculation
            // everytime. see zywscq's explanation.
        }
        //right = s.length
        return right - left;
    }
}
