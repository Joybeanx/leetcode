package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/">Minimum Number of Arrows to
 * Burst Balloons</a>
 *
 * @author Joybean
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public static int findMinArrowShots1(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int shots = 1;
        int endSoFar = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] interval = points[i];
            if (interval[0] > endSoFar) {
                endSoFar = interval[1];
                shots++;
            }
        }
        return shots;
    }
}
