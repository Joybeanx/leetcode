package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/frequency-of-the-most-frequent-element/">Frequency of the Most Frequent
 * Element</a>
 *
 * @author Joybean
 */
public class FrequencyOfTheMostFrequentElement {
    /**
     * <a href="https://michael.blog.csdn.net/article/details/116130754">Prefix sum + Binary search</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maxFrequency1(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 1;
        int right = nums.length;
        //int array is not enough,max:10^5*10^5
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        //search range [left,right)
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            //Can k operations be feasible when max frequency is mid?
            if (isFeasible(nums, prefixSum, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static boolean isFeasible(int[] nums, long[] prefixSum, int freq, int k) {
        for (int i = freq; i < prefixSum.length; i++) {
            if (prefixSum[i] - prefixSum[i - freq] + k >= nums[i - 1] * (long)freq) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sliding window
     * TODO
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maxFrequency2(int[] nums, int k) {
        return 0;
    }

    //    Wrong binary search
    //    public static int maxFrequency(int[] nums, int k) {
    //        Arrays.sort(nums);
    //        int left = 0;
    //        int right = nums.length - 1;
    //        //search range [left,right)
    //        while (left < right) {
    //            int mid = (left + right + 1) >>> 1;
    //            if (exceedNumOfOperations(nums, mid, k)) {
    //                right = mid - 1;
    //            } else {
    //                left = mid;
    //            }
    //        }
    //        return left + 1;
    //    }
    //
    //    private static boolean exceedNumOfOperations(int[] nums, int targetIdx, int k) {
    //        int cnt = 0;
    //        for (int i = targetIdx - 1; i >= 0; i--) {
    //            cnt += nums[targetIdx] - nums[i];
    //            if (cnt > k) {
    //                return true;
    //            }
    //        }
    //        return false;
    //    }

}
