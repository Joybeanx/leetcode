package com.joybean.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/meeting-rooms-ii/description/">Meeting Rooms II</a>
 *
 * @author Joybean
 */
public class MeetingRoomII {

    /**
     * Greedy algorithm
     * @param intervals
     * @return
     * @see https://www.lintcode.com/problem/919/
     */
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        Queue<Interval> rooms = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        for (Interval interval : intervals) {
            if (!rooms.isEmpty()) {
                Interval room = rooms.peek();
                if (interval.start >= room.end) {
                    room.end = interval.end;
                    continue;
                }
            }
            rooms.offer(interval);
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
