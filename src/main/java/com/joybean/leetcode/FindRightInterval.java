package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/find-right-interval/">Find Right Interval</a>
 *
 * @author Joybean
 */
public class FindRightInterval {
    /**
     * Binary search
     *
     * @param intervals
     * @return
     */
    public static int[] findRightInterval1(int[][] intervals) {
        Integer[] sortedIndexes = IntStream.range(0, intervals.length).mapToObj(Integer::valueOf).toArray(
            Integer[]::new);
        Arrays.sort(sortedIndexes, Comparator.comparing(i -> intervals[i][0]));
        int[] ans = new int[sortedIndexes.length];
        for (int i = 0; i < sortedIndexes.length; i++) {
            ans[i] = binarySearch(i, sortedIndexes, intervals);
        }
        return ans;
    }

    private static int binarySearch(int i, Integer[] sortedIndexes, int[][] intervals) {
        int left = 0;
        int right = sortedIndexes.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (intervals[sortedIndexes[mid]][0] == intervals[i][1]) {
                return sortedIndexes[mid];
            }
            if (intervals[sortedIndexes[mid]][0] < intervals[i][1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == intervals.length) {
            return -1;
        }
        return sortedIndexes[left];
    }

    /**
     * TreeMap
     * TODO
     *
     * @param intervals
     * @return
     */
    public static int[] findRightInterval2(int[][] intervals) {
        return null;
    }
}
