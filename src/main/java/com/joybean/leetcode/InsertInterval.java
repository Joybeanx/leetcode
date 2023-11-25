package com.joybean.leetcode;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/insert-interval/">Insert Interval</a>
 *
 * @author Joybean
 */
public class InsertInterval {
    /**
     * Add new interval first and then merge overlapping intervals
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert1(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList<>();
        int i = 0;
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            list.add(intervals[i]);
            i++;
        }
        list.add(newInterval);
        for (int j = i; j < intervals.length; j++) {
            int[] last = list.getLast();
            if (intervals[j][0] <= last[1]) {
                last[0] = Math.min(last[0], intervals[j][0]);
                last[1] = Math.max(last[1], intervals[j][1]);
            } else {
                list.add(intervals[j]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * <a href="https://leetcode.com/problems/insert-interval/solutions/21602/short-and-straight-forward-java-solution
     * /">merge overlapping intervals and then add</a>
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList<>();
        int i = 0;
        //add all the intervals ending before newInterval starts
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            list.add(intervals[i++]);
        }
        //merge all overlapping intervals to one considering newInterval
        int start = newInterval[0];
        int end = newInterval[1];
        while (i < intervals.length && end >= intervals[i][0]) {
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
            i++;
        }
        list.add(new int[] {start, end});
        // add all the rest
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
