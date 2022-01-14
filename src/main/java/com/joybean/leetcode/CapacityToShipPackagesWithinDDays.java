package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/">Capacity To Ship Packages Within D
 * Days</a>
 *
 * @author Joybean
 */
public class CapacityToShipPackagesWithinDDays {
    /**
     * Binary search 1
     *
     * @param weights
     * @param days
     * @return
     */
    public static int shipWithinDays1(int[] weights, int days) {
        int left = 1;
        int right = Arrays.stream(weights).sum();
        //search range [left,right)
        while (left < right) {
            int mid = (left + right) >>> 1;
            int requiredDays = getRequiredDays(mid, weights);
            if (requiredDays > days) {
                left = mid + 1;
                //input: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],10
                //requiredDays=7,mid=10
            } else {
                //mid may be a possible answer
                //for example:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10],10 requiredDays=7,mid=10
                right = mid;
            }
        }
        return left;
    }

    private static int getRequiredDays(int capacity, int[] weights) {
        int days = 1;
        int cur = 0;
        for (int w : weights) {
            if (w > capacity) {
                return Integer.MAX_VALUE;
            }
            cur += w;
            if (cur > capacity) {
                cur = w;
                days++;
            }
        }
        return days;
    }

    /**
     * <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/discuss/256729/JavaC%2B%2BPython-Binary-Search">Better
     * binary search</a>
     *
     * @param weights
     * @param days
     * @return
     */
    public static int shipWithinDays2(int[] weights, int days) {
        int left = 0;
        int right = 0;
        //Shrink initial search range as small as possible
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (isOverDays(weights, mid, days)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static boolean isOverDays(int[] weights, int mid, int days) {
        int requiredDays = 1;
        int cur = 0;
        for (int w : weights) {
            if (cur + w > mid) {
                requiredDays++;
                cur = 0;
            }
            cur += w;
            if (requiredDays > days) {
                return true;
            }
        }
        return false;
    }

}
