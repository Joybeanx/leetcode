package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/string-to-integer-atoi/description/">String to Integer (atoi)</a>
 *
 * @author Joybean
 */
public class StringToInteger {
    /**
     * Straight forward solution
     *
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            i++;
        }
        while (i < n && s.charAt(i) == '0') {
            i++;
        }
        Double val = 0D;
        while (i < n) {
            int digit = s.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            val = (10 * val + digit);
            i++;
        }
        val = val * sign;
        if (val > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (val < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return val.intValue();
    }
}
