package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/count-special-integers/">Count Special Integers</a>
 *
 * @author Joybean
 */
public class CountSpecialIntegers {
    /**
     * Time Limit Exceeded
     *
     * @param n
     * @return
     */
    public static int countSpecialNumbers1(int n) {
        int ans = 0;
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (dp[i] = isSpecialNumbers(i, dp)) {
                ans++;
            }
        }
        return ans;
    }

    private static boolean isSpecialNumbers(int n, boolean[] dp) {
        String digits = String.valueOf(n);
        String lastDigit = String.valueOf(digits.charAt(digits.length() - 1));
        int s = n / 10;
        if (s > 0) {
            if (!dp[s]) {
                return false;
            }
            if (String.valueOf(s).contains(lastDigit)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <a href="https://leetcode.com/problems/count-special-integers/discuss/2422090/C%2B%2B-with-explanation-Digit-Dynamic-Programming">Digit DP</a>
     * TODO
     *
     * @param n
     * @return
     */
    public static int countSpecialNumbers2(int n) {
        return 0;
    }
}
