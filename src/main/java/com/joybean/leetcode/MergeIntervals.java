package com.joybean.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/merge-intervals/">Merge Intervals</a>
 *
 * @author Joybean
 * @see NonOverlappingIntervals
 */
public class MergeIntervals {
    /**
     * Add new interval until its merge is done
     *
     * @param intervals
     * @return
     */
    public static int[][] merge1(int[][] intervals) {
        int n = intervals.length;
        int[][] copy = Arrays.copyOf(intervals, n + 1);
        //Sentinel node
        copy[n] = new int[]{10001, 10001};
        Arrays.sort(copy, Comparator.comparing(a -> a[0]));
        //Use LinkedList instead of ArrayList
        List<int[]> merged = new LinkedList<>();
        int[] prev = copy[0];
        for (int i = 1; i < n + 1; i++) {
            int[] current = copy[i];
            if (prev[1] >= current[0]) {
                prev = new int[]{prev[0], Math.max(current[1], prev[1])};
            } else {
                merged.add(prev);
                prev = current;
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    /**
     * Add interval first and then merge
     *
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (list.isEmpty() || !isOverlapping(list.getLast(), cur)) {
                list.add(cur);
                continue;
            }
            list.getLast()[1] = Math.max(cur[1], list.getLast()[1]);
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return list.toArray(new int[list.size()][2]);
    }

    private boolean isOverlapping(int[] a, int[] b) {
        return a[0] <= b[1] && b[0] <= a[1];
    }

    /**
     * <a href="https://leetcode.com/problems/merge-intervals/solutions/127480/merge-intervals/?orderBy=most_votes">Add interval first and then merge</a>
     *
     * @param intervals
     * @return
     */
    public static int[][] merge3(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            int[] last = merged.getLast();
            if (curInterval[0] <= last[1]) {
                last[1] = Math.max(curInterval[1], last[1]);
            } else {
                merged.add(curInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * <a href="https://leetcode.com/problems/merge-intervals/solutions/355318/fully-explained-and-clean-interval-tree-for-facebook-follow-up-no-sorting/">Interval Tree</a>
     * TODO
     *
     * @param intervals
     * @return
     */
    public int[][] merge4(int[][] intervals) {
        return null;
    }


}
