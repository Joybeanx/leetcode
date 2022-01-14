package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/koko-eating-bananas/">Koko Eating Bananas</a>
 *
 * @author Joybean
 */
public class KokoEatingBananas {
    /**
     * Binary search 1
     *
     * @param piles
     * @param h
     * @return
     */
    public static int minEatingSpeed1(int[] piles, int h) {
        int left = 1;
        int right = (int)1e9;
        //search range [left,right)
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (isOverHours(piles, mid, h)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * <a href="https://leetcode.com/problems/koko-eating-bananas/discuss/152506/Binary-Search-Java-Python-with
     * -Explanations">Binary search 2</a>
     *
     * @param piles
     * @param h
     * @return
     */
    public static int minEatingSpeed2(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().orElse(0);
        //search range [left,right]
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (isOverHours(piles, mid, h)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static boolean isOverHours(int[] piles, int mid, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + mid - 1) / mid;
            if (hours > h) {
                return true;
            }
        }
        return false;
    }
}
