package com.joybean.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/meeting-rooms-ii/description/">Meeting Rooms II</a>
 *
 * @author Joybean
 */
public class MeetingRoomII {

    /**
     * Greedy algorithm: merge intervals
     *
     * @param intervals
     * @return
     * @see https://www.lintcode.com/problem/919/
     */
    public static int minMeetingRooms1(List<Interval> intervals) {
        //Sort the intervals based on their start times. This ensures that we process them in chronological order.
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        //Use min heap to keep track of the intervals of the ongoing meetings. The heap will store the end times in
        //ascending order.
        Queue<Interval> rooms = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        for (Interval interval : intervals) {
            if (!rooms.isEmpty() && interval.start >= rooms.peek().end) {
                rooms.peek().end = interval.end;
                continue;
            }
            rooms.offer(interval);
        }
        return rooms.size();
    }

    /**
     * Greedy algorithm 2
     *
     * @param intervals
     * @return
     * @see https://www.lintcode.com/problem/919/
     */
    public static int minMeetingRooms2(List<Interval> intervals) {
        //Sort the intervals based on their start times. This ensures that we process them in chronological order.
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        //Use min heap to keep track of the end times of the ongoing meetings. The heap will store the end times in
        //ascending order.
        Queue<Integer> rooms = new PriorityQueue<>();
        rooms.offer(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start >= rooms.peek()) {
                rooms.poll();
            }
            rooms.offer(interval.end);
        }
        return rooms.size();
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
