package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/kth-missing-positive-number/">Kth Missing Positive Number</a>
 *
 * @author Joybean
 */
public class KthMissingPositiveNumber {
    /**
     * Binary search
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findKthPositive1(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int missingCnt = arr[left] - left - 1;
        if (missingCnt >= k) {
            return left + k;
        }
        return left + k + 1;
    }

    /**
     * <a href="https://leetcode.com/problems/kth-missing-positive-number/discuss/779999/JavaC%2B%2BPython-O(logN)">Optimized
     * binary search </a>
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findKthPositive2(int[] arr, int k) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //non-missing number count + k missing number count
        return left + k;
    }
}
