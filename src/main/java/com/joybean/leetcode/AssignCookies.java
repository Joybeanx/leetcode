package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/assign-cookies/">Assign Cookies</a>
 *
 * @author Joybean
 */
public class AssignCookies {
    /**
     * Sorting + Two pointers greedy
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren1(int[] g, int[] s) {
        int ans = 0;
        if (s.length == 0) {
            return ans;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j++]) {
                i++;
                ans++;
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/assign-cookies/discuss/93987/Simple-Greedy-Java-Solution">Concise
     * greedy solution</a>
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                i++;
            }
        }
        return i;
    }
}
