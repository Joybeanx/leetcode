package com.joybean.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/meeting-rooms/description/">Meeting Rooms</a>
 *
 * @author Joybean
 */
public class MeetingRoom {

    /**
     * Sort and check for overlaps
     *
     * @param intervals
     * @return
     * @see https://www.lintcode.com/problem/920/
     */
    public static boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        Integer prevEnd = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (interval.start < prevEnd) {
                return false;
            }
        }
        return true;
    }


    public static class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
