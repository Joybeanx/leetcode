package com.joybean.leetcode;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/add-strings/">Add Strings</a>
 *
 * @author Joybean
 */
public class AddStrings {
    //TODO
    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int i = m - 1;
        int j = n - 1;
        int carry = 0;
        String ans = "";
        while (i >= 0 || j >= 0) {
            char c1 = i >= 0 ? num1.charAt(i--) : '0';
            char c2 = j >= 0 ? num2.charAt(j--) : '0';
            int val1 = c1 - '0';
            int val2 = c2 - '0';

            int sum = val1 + val2 + carry;
            int val = sum % 10;
            carry = sum / 10;
            ans = val + ans;
        }
        if (carry > 0) {
            ans = carry + ans;
        }
        return ans;
    }
}
