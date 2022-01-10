package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/">Find the Smallest Divisor Given
 * a Threshold</a>
 *
 * @author Joybean
 */
public class FindTheSmallestDivisorGivenAThreshold {
    /**
     * Binary search
     *
     * @param nums
     * @param threshold
     * @return
     */
    public static int smallestDivisor1(int[] nums, int threshold) {
        int left = 1;
        int right = Arrays.stream(nums).max().orElse(0);
        while (left < right) {
            int mid = (left + right) >>> 1;
            int sum = Arrays.stream(nums).map(n -> (int)Math.ceil((double)n / mid)).sum();
            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * <a href="https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/discuss/446376/JavaC%2B
     * %2BPython-Binary-Search">Optimized binary search</a>
     *
     * @param nums
     * @param threshold
     * @return
     */
    public static int smallestDivisor2(int[] nums, int threshold) {
        int left = 1;
        //int right = (int)1e6
        int right = Arrays.stream(nums).max().orElse(0);
        while (left < right) {
            int mid = (left + right) >>> 1;
            int sum = 0;
            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }
            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
