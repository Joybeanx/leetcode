package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/plates-between-candles/">Plates Between Candles</a>
 *
 * @author Joybean
 */
public class PlatesBetweenCandles {
    /**
     * Binary search
     *
     * @param s
     * @param queries
     * @return
     */
    public static int[] platesBetweenCandles1(String s, int[][] queries) {
        //candles[i] stores the number of candles in s[0...i]
        int[] candles = new int[s.length()];
        if (s.charAt(0) == '|') {
            candles[0] = 1;
        }
        for (int i = 1; i < candles.length; i++) {
            char ch = s.charAt(i);
            candles[i] = candles[i - 1];
            if (ch == '|') {
                candles[i]++;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int startCandlePos = binarySearch(candles, s, query[0], query[0] + 1, s.length() - 1,
                candles[query[0]] + 1);
            if (startCandlePos == -1) {
                ans[i] = 0;
                continue;
            }
            int endCandlePos = binarySearch(candles, s, query[1], startCandlePos, query[1] - 1, candles[query[1]]);
            if (endCandlePos == -1) {
                ans[i] = 0;
                continue;
            }
            ans[i] = endCandlePos - startCandlePos - candles[endCandlePos] + candles[startCandlePos];
        }
        return ans;
    }

    private static int binarySearch(int[] candles, String s, int i, int left, int right, int target) {
        if (s.charAt(i) == '|') {
            return i;
        }
        if (target == 0) {
            return -1;
        }
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (candles[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == s.length()) {
            return -1;
        }
        return left;
    }

    /**
     * <a href="https://leetcode.com/problems/plates-between-candles/discuss/1549018/JavaC%2B%2BPython-Binary-Search
     * -and-O(Q-%2B-N)-Solution">Optimized binary search</a>
     *
     * @param s
     * @param queries
     * @return
     */
    public static int[] platesBetweenCandles2(String s, int[][] queries) {
        //candles[i] stores the index of candles in s[0...i]
        List<Integer> candles = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                candles.add(i);
            }
        }
        int[] ans = new int[queries.length];
        if (candles.isEmpty()) {
            return ans;
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            //Find the first candle index which is greater than query[0]
            int left = binarySearchLeft1(candles, query[0]);
            //Find the last candle index which is less than query[1]
            int right = binarySearchRight1(candles, query[1]);
            ans[i] = left > right ? 0 : (candles.get(right) - candles.get(left) - right + left);
        }
        return ans;
    }

    private static int binarySearchLeft1(List<Integer> candles, int target) {
        int left = 0;
        int right = candles.size() - 1;
        //search range [left,right)
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (candles.get(mid) == target) {
                return mid;
            }
            if (candles.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int binarySearchLeft2(List<Integer> candles, int target) {
        int left = 0;
        int right = candles.size() - 1;
        //search range [left,right]
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (candles.get(mid) == target) {
                return mid;
            }
            if (candles.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static int binarySearchRight1(List<Integer> candles, int target) {
        int left = 0;
        int right = candles.size() - 1;
        //search range [left,right)
        while (left < right) {
            //Always gives the higher mid,so that this won't make the search range stuck
            int mid = (left + right + 1) >>> 1;
            if (candles.get(mid) == target) {
                return mid;
            }
            if (candles.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private static int binarySearchRight2(List<Integer> candles, int target) {
        int left = 0;
        int right = candles.size() - 1;
        //search range [left,right]
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (candles.get(mid) == target) {
                return mid;
            }
            if (candles.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * Prefix sum
     * TODO
     *
     * @param s
     * @param queries
     * @return
     */
    public static int[] platesBetweenCandles3(String s, int[][] queries) {
        return null;
    }

    /**
     * <a href="https://leetcode.com/problems/plates-between-candles/discuss/1549018/JavaC%2B%2BPython-Binary-Search
     * -and-O(Q-%2B-N)-Solution">Next Candle</a>
     * TODO
     *
     * @param s
     * @param queries
     * @return
     */
    public static int[] platesBetweenCandles4(String s, int[][] queries) {
        return null;
    }
}
