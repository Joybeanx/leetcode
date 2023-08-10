package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/most-profit-assigning-work/">Most Profit Assigning Work</a>
 *
 * @author Joybean
 */
public class MostProfitAssigningWork {
    /**
     * Binary search
     *
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public static int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        int[][] jobs = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            jobs[i] = new int[]{difficulty[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparing(a -> a[0]));
        int[] prefixMax = new int[jobs.length + 1];
        for (int i = 1; i <= jobs.length; i++) {
            prefixMax[i] = Math.max(jobs[i - 1][1], prefixMax[i - 1]);
        }
        int ans = 0;
        for (int w : worker) {
            int idx = binarySearch1(jobs, w);
            ans += prefixMax[idx + 1];
        }
        return ans;
    }

    private static int binarySearch1(int[][] jobs, int target) {
        int left = 0;
        int right = jobs.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (jobs[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (jobs[left][0] > target) {
            return -1;
        }
        return left;
    }

    /**
     * <a href="https://qiyileetcode.com/problems/most-profit-assigning-work/editorial/">Binary search:find upper bound (by calvinchankf)</a>
     *
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public static int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int[][] jobs = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            jobs[i] = new int[]{difficulty[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparing(a -> a[0]));
        int[] prefixMax = new int[jobs.length + 1];
        for (int i = 1; i <= jobs.length; i++) {
            prefixMax[i] = Math.max(jobs[i - 1][1], prefixMax[i - 1]);
        }
        int ans = 0;
        for (int w : worker) {
            //find upper bound
            int idx = binarySearch2(jobs, w) - 1;
            if (idx > -1) {
                ans += prefixMax[idx + 1];
            }
        }
        return ans;
    }

    /**
     * Binary search 3:find upper bound
     *
     * @param jobs
     * @param target
     * @return
     * @see <a href ="https://github.com/python/cpython/blob/3.9/Lib/bisect.py#L15">Python bisect_right</a>
     * @see FindSmallestLetterGreaterThanTarget#nextGreatestLetter2(char[], char)
     */
    private static int binarySearch2(int[][] jobs, int target) {
        int left = 0;
        int right = jobs.length;
        //search range [0,jobs.length)
        while (left < right) {
            int mid = (left + right) >>> 1;
            //100% sure logic
            if (jobs[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * <a href="https://leetcode.com/problems/most-profit-assigning-work/editorial/">Sorting Events</a>
     * TODO
     *
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public static int maxProfitAssignment3(int[] difficulty, int[] profit, int[] worker) {
        return 0;
    }
}
