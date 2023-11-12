package com.joybean.leetcode;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/exam-room/">Exam Room</a>
 *
 * @author Joybean
 */
public class ExamRoom {
    private PriorityQueue<int[]> pq;
    private int n;

    /**
     * <a href="https://leetcode.com/problems/exam-room/solutions/139897/java-priorityqueue-solution-o-logn-for-seat
     * -o-n-for-leave/">Priority Queue(by IrisGuo)</a>
     *
     * @param n
     */
    public ExamRoom(int n) {
        this.pq = new PriorityQueue<>((a, b) -> {
            int dist1 = maxDistAfterSittingIn(a);
            int dist2 = maxDistAfterSittingIn(b);
            if (dist1 == dist2) {
                //Make sure student sit in the seat with the lowest number if there are multiple such seats
                return a[0] - b[0];
            }
            return dist2 - dist1;
        });
        this.n = n;
        //Add dummy interval so that we don't need to handle so many edge cases
        pq.offer(new int[] {-1, n});
    }

    private int maxDistAfterSittingIn(int[] interval) {
        //dummy seat
        if (interval[0] == -1) {
            return interval[1];
        }
        //dummy seat
        if (interval[1] == n) {
            return n - 1 - interval[0];
        }
        return (interval[1] - interval[0]) / 2;
    }

    public int seat() {
        int[] longestInterval = pq.poll();
        int pos;
        if (longestInterval[0] == -1) {
            pos = 0;
        } else if (longestInterval[1] == n) {
            pos = n - 1;
        } else {
            pos = longestInterval[0] + (longestInterval[1] - longestInterval[0]) / 2;
        }
        pq.offer(new int[] {longestInterval[0], pos});
        pq.offer(new int[] {pos, longestInterval[1]});
        return pos;
    }

    public void leave(int p) {
        int[] prev = null;
        int[] next = null;
        for (int[] interval : pq) {
            if (interval[0] == p) {
                next = interval;
            }
            if (interval[1] == p) {
                prev = interval;
            }
        }
        pq.remove(next);
        pq.remove(prev);
        pq.offer(new int[] {prev[0], next[1]});
    }
}
