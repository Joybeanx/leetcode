package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/heaters/">Heaters</a>
 *
 * @author Joybean
 */
public class Heaters {
    /**
     * Binary search
     *
     * @param houses
     * @param heaters
     * @return
     */
    public static int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;
        for (int house : houses) {
            int pos = binarySearch(house, heaters);
            int nearestHeaterDistance = Math.min(pos < heaters.length ? heaters[pos] - house : Integer.MAX_VALUE,
                pos > 0 ? house - heaters[pos - 1] : Integer.MAX_VALUE);
            ans = Math.max(ans, nearestHeaterDistance);
        }
        return ans;
    }

    private static int binarySearch(int target, int[] heaters) {
        int left = 0;
        int right = heaters.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (heaters[mid] == target) {
                return mid;
            }
            if (heaters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
