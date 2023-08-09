package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/maximum-profit-in-job-scheduling/">Maximum Profit in Job Scheduling</a>
 *
 * @author Joybean
 */
public class MaximumProfitInJobScheduling {
    /**
     * Iterative(bottom-up) DP + Binary search
     *
     * @param startTime
     * @param endTime
     * @param profit
     * @return
     */
    public static int jobScheduling1(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        int n = jobs.length;
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < dp.length; i++) {
            int next = binarySearchInsertPos(jobs[i][0], i, jobs);
            dp[i] = Math.max(dp[i - 1], (next == 0 ? 0 : dp[next - 1]) + jobs[i][2]);
        }
        return dp[n - 1];
    }

    /**
     * @see SearchInsertPosition#searchInsert4(int[], int)
     */
    private static int binarySearchInsertPos(int target, int endIdx, int[][] jobs) {
        int left = 0;
        int right = endIdx;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * <a href="https://leetcode.com/problems/maximum-profit-in-job-scheduling/solutions/409009/java-c-python-dp-solution/">Iterative(bottom-up) DP + TreeMap</a>
     * TODO
     *
     * @param startTime
     * @param endTime
     * @param profit
     * @return
     */
    public static int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        return 0;
    }
}
