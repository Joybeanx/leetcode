package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/non-overlapping-intervals/">Non-overlapping Intervals</a>
 *
 * @author Joybean
 */
public class NonOverlappingIntervals {
    /**
     * Greedy algorithm（Interval Scheduling）
     *
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int removed = 0;
        int endSoFar = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] < endSoFar) {
                removed++;
            } else {
                endSoFar = interval[1];
            }
        }
        return removed;
    }
}
