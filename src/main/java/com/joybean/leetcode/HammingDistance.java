package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/hamming-distance/description/">Hamming Distance</a>
 *
 * @author Joybean
 */
public class HammingDistance {
    /**
     * bit manipulation
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance1(int x, int y) {
        Integer xor = x ^ y;
        int ans = 0;
        int k = 0;
        while (k <= 31) {
            if ((xor & (1 << k)) != 0) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/hamming-distance/solutions/94705/my-c-solution-using-bit-manipulation
     * /">Optimized bit manipulation</a>
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance2(int x, int y) {
        Integer xor = x ^ y;
        int ans = 0;
        for (int k = 0; k < 32; k++) {
            ans += (xor >> k) & 1;
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/hamming-distance/solutions/94698/java-1-line-solution-d/">Concise bit
     * manipulation</a>
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
