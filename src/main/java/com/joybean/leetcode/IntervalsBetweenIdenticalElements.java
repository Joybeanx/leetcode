package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/intervals-between-identical-elements/">Intervals Between Identical
 * Elements</a>
 *
 * @author Joybean
 */
public class IntervalsBetweenIdenticalElements {
    /**
     * Straight forward:Time Limit Exceeded
     *
     * @param arr
     * @return
     */
    public static long[] getDistances1(int[] arr) {
        long[] ans = new long[arr.length];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int each = arr[i];
            map.putIfAbsent(each, new HashSet<>());
            map.get(each).add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int each = arr[i];
            Set<Integer> indexes = map.get(each);
            indexes.remove(i);
            for (int idx : indexes) {
                int dist = Math.abs(idx - i);
                ans[i] += dist;
                ans[idx] += dist;
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/intervals-between-identical-elements/discuss/1647630/Python3-Java-C%2B
     * %2B-DictionaryMap-and-Prefix-Sum-O(n)">Prefix sum,Time complexity:O(n)</a>
     *
     * @param arr
     * @return
     */
    public static long[] getDistances2(int[] arr) {
        long[] ans = new long[arr.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> indexes = entry.getValue();
            long[] prefixSum = new long[indexes.size() + 1];
            for (int i = 1; i < prefixSum.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + indexes.get(i - 1);
            }
            for (int i = 0; i < indexes.size(); i++) {
                int idx = indexes.get(i);
                //difference of indices on left + difference of indices on right
                ans[idx] =
                    i * (long)idx - prefixSum[i] + prefixSum[indexes.size()] - prefixSum[i + 1]
                        - (indexes.size() - 1 - i) * (long)idx;
            }
        }
        return ans;
    }
}
