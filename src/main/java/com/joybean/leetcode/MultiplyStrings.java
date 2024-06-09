package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/multiply-strings/">Multiply Strings</a>
 *
 * @author Joybean
 */
public class MultiplyStrings {
    /**
     * Use zero extension and addition
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        String ans = "";
        for (int i = 0; i < m; i++) {
            int digit = num1.charAt(i) - '0';
            String baseProduct = num2;
            //zero extension
            for (int j = 0; j < m - i - 1; j++) {
                baseProduct += "0";
            }
            String partProduct = "";
            for (int k = 0; k < digit; k++) {
                partProduct = add(partProduct, baseProduct);
            }
            ans = add(ans, partProduct);
        }
        return ans;
    }

    public static String add(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int k = Math.min(m, n);
        String ans = "";
        int carry = 0;
        for (int i = 1; i <= k; i++) {
            int sum = (num1.charAt(m - i) - '0') + (num2.charAt(n - i) - '0') + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ans = digit + ans;
        }
        for (int i = num1.length() - k - 1; i >= 0; i--) {
            int sum = (num1.charAt(i) - '0') + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ans = digit + ans;
        }
        for (int i = num2.length() - k - 1; i >= 0; i--) {
            int sum = (num2.charAt(i) - '0') + carry;
            int digit = sum % 10;
            carry = digit / 10;
            ans = digit + ans;
        }
        if (carry > 0) {
            ans = carry + ans;
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.cn/problems/multiply-strings/solutions/372098/zi-fu-chuan-xiang-cheng-by-leetcode
     * -solution/">compute products for each pair of digits </a>
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] digits = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                int mul = digit1 * digit2;
                int sum = digits[i + j + 1] + mul;
                digits[i + j + 1] = sum % 10;
                int carry = sum / 10;
                digits[i + j] += carry;
            }
        }
        int k = 0;
        while (k < m + n && digits[k] == 0) {
            k++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = k; i < m + n; i++) {
            sb.append(digits[i]);
        }
        return sb.toString();
    }
}
