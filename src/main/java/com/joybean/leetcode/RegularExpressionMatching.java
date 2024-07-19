package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/regular-expression-matching/">Regular Expression Matching</a>
 *
 * @author Joybean
 */
public class RegularExpressionMatching {
    /**
     * <a href="https://leetcode.com/problems/regular-expression-matching/editorial/">Recursion</a>
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch1(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch1(s, p.substring(2)) ||
                    (firstMatch && isMatch1(s.substring(1), p)));
        } else {
            return firstMatch && isMatch1(s.substring(1), p.substring(1));
        }
    }

    /**
     * Iterative(bottom-up) DP
     * TODO
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch2(String s, String p) {
        return false;
    }
}
