package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/minimum-speed-to-arrive-on-time/">Minimum Speed to Arrive on Time</a>
 *
 * @author Joybean
 */
public class MinimumSpeedToArriveOnTime {
    /**
     * Binary search 1
     *
     * @param dist
     * @param hour
     * @return
     */
    public static int minSpeedOnTime1(int[] dist, double hour) {
        if (dist.length > Math.ceil(hour)) {
            return -1;
        }
        int left = 1;
        int right = 0;
        for (int d : dist) {
            right = Math.max(d, right);
        }
        //hour has at most two digits after the decimal point
        //[1,1,100000],2.01
        right *= 100;
        //search range [left,right)
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (isOverTime(dist, mid, hour)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static boolean isOverTime(int[] dist, int speed, double hour) {
        int requiredHours = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            requiredHours += (dist[i] + speed - 1) / speed;
            if (requiredHours > hour) {
                return true;
            }
        }

        return (requiredHours + dist[dist.length - 1] / (double) speed) > hour;
    }

    /**
     * Binary search 2
     *
     * @param dist
     * @param hour
     * @return
     */
    public static int minSpeedOnTime2(int[] dist, double hour) {
        return 0;
    }
}
