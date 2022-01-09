package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/">Minimum Number of Days to Make m Bouquets</a>
 *
 * @author Joybean
 */
public class MinimumNumberOfDaysToMakeMBouquets {
    /**
     * <a href="https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/discuss/686316/JavaC%2B%2BPython-Binary-Search">Binary search</a>
     *
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public static int minDays1(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int left = 1;
        int right = (int) 1e9;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int bouquets = 0;
            int bloomed = 0;
            for (int d : bloomDay) {
                //Calculate how many bouquets we can make after dth day
                if (mid < d) {
                    bloomed = 0;
                } else if (++bloomed == k) {
                    bouquets++;
                    bloomed = 0;
                }
            }
            if (bouquets < m) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left;
    }
}
