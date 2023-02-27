package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/">Longest Common Prefix</a>
 *
 * @author Joybean
 */
public class LongestCommonPrefix {
    /**
     * Straight-forward solution
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String ans = "";
        int i = 0;
        while (true) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j - 1].length() <= i) {
                    return ans;
                }
                char prev = strs[j - 1].charAt(i);
                char curr = strs[j].charAt(i);
                if (curr != prev) {
                    return ans;
                }
                if (j == strs.length - 1) {
                    ans += curr;
                    i++;
                }
            }
        }
    }

    /**
     * <a href="https://leetcode.com/problems/longest-common-prefix/solutions/1405155/java-detailed-solution-0-ms-faster-than-100/">Horizontal scanning</a>
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
