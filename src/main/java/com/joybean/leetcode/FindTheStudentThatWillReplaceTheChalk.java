package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/">Find the Student that Will
 * Replace the Chalk</a>
 *
 * @author Joybean
 */
public class FindTheStudentThatWillReplaceTheChalk {

    /**
     * Prefix sum + Binary search
     *
     * @param chalk
     * @param k
     * @return
     */
    public static int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + chalk[i - 1];
        }
        long target = k % prefixSum[n];
        return binarySearch(prefixSum, target);
    }

    private static int binarySearch(long[] prefixSum, long target) {
        int left = 1;
        int right = prefixSum.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (prefixSum[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
}
