package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/magnetic-force-between-two-balls/">Magnetic Force Between Two Balls</a>
 *
 * @author Joybean
 */
public class MagneticForceBetweenTwoBalls {
    /**
     * Binary search 1
     *
     * @param position
     * @param m
     * @return
     */
    public static int maxDistance1(int[] position, int m) {
        //Sort can make thing easier
        Arrays.sort(position);
        int left = 0;
        int right = position[position.length - 1];
        //search range [left,right)
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (needMoreBalls(position, mid, m)) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private static boolean needMoreBalls(int[] position, int minForce, int m) {
        int balls = 1;
        int prev = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - prev >= minForce) {
                balls++;
                prev = position[i];
            }
        }
        return balls < m;
    }

    /**
     * Binary search 2
     * TODO
     *
     * @param position
     * @param m
     * @return
     */
    public static int maxDistance2(int[] position, int m) {
        return 0;
    }
}
