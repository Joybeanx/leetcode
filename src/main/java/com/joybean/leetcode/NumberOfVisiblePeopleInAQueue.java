package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/number-of-visible-people-in-a-queue/">Number of Visible People in a Queue</a>
 *
 * @author Joybean
 */
public class NumberOfVisiblePeopleInAQueue {
    /**
     * Brute force,TLE
     *
     * @param heights
     * @return
     */
    public static int[] canSeePersonsCount1(int[] heights) {
        int[] ans = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int max = 0;
            int cnt = 0;
            for (int j = i + 1; j < heights.length; j++) {
                if (Math.min(heights[i], heights[j]) > max) {
                    cnt++;
                }
                max = Math.max(max, heights[j]);
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
