package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/two-best-non-overlapping-events/">Two Best Non-Overlapping Events</a>
 *
 * @author Joybean
 */
public class TwoBestNonOverlappingEvents {
    /**
     * Sort + Heap
     * @param events
     * @return
     */
    public static int maxTwoEvents1(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        //Declare global variable can make sure the polled event can be used to combine with later events
        int maxValue = 0;
        for (int[] event : events) {
            while (!pq.isEmpty() && pq.peek()[1] < event[0]) {
                maxValue = Math.max(maxValue, pq.poll()[2]);
            }
            pq.offer(event);
            ans = Math.max(ans, event[2] + maxValue);
        }
        return ans;
    }
}
