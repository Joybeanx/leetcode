package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/count-number-of-texts/">Count Number of Texts</a>
 *
 * @author Joybean
 */
public class CountNumberOfTexts {
    /**
     * Iterative(bottom-up) DP
     *
     * @param pressedKeys
     * @return
     */
    public static int countTexts1(String pressedKeys) {
        int mod = (int) 1e9 + 7;
        pressedKeys = "1111" + pressedKeys;
        int n = pressedKeys.length();
        //dp[i] represents number of possible text messages pressedKeys[0...i]
        long[] dp = new long[n];
        for (int i = 0; i < 4; i++) {
            dp[i] = 1;
        }
        for (int i = 4; i < n; i++) {
            dp[i] = dp[i - 1];
            int k = 0;
            int letterCntOnKey = Arrays.asList('7', '9').contains(pressedKeys.charAt(i - k)) ? 4 : 3;
            while (k < letterCntOnKey - 1 && pressedKeys.charAt(i - k) == pressedKeys.charAt(i - k - 1)) {
                dp[i] = (dp[i] + dp[i - k - 2]) % mod;
                k++;
            }
        }
        return (int) dp[n - 1];
    }

    /**
     * <a href="https://leetcode.com/problems/count-number-of-texts/discuss/2017714/O(n)-or-O(1)">Optimized iterative(bottom-up) DP using circular array</a>
     * TODO
     *
     * @param pressedKeys
     * @return
     */
    public static int countTexts2(String pressedKeys) {
        return 0;
    }
}
