package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">Median of Two Sorted Arrays</a>
 *
 * @author Joybean
 */
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        boolean even = (len & 1) == 0;
        int targetIdx = len / 2 - (even ? 1 : 0);
        int i = 0;
        int j = 0;
        int cur = 0;
        double median = 0;
        while (i < nums1.length || j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                if (i < nums1.length - 1) {
                    i++;
                } else if (j < nums2.length - 1) {
                    j++;
                }
            } else {
                if (j < nums2.length - 1) {
                    j++;
                } else if (i < nums1.length - 1) {
                    i++;
                }
            }
            if (i + j == targetIdx) {
                if (even) {
                    median = Math.min(nums1[i], nums2[j]);
                }
            } else if (i + j == targetIdx + 1) {
                if (even) {
                    median += cur;
                    median = new Double(median) / 2;
                }
                return median;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/2471/very-concise-o-log-min-m-n-iterative-solution-with-detailed-explanation/">Find a cut position that makes nums[L1]<nums[R2] and nums[L2]<nums[R1]</a>
     * TODO
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays2(nums2, nums1);
        }
        int left = 0;
        int right = 2 * m;

        while (left < right) {
            int mid = (left + right) >>> 1;

        }
        return 0;
    }
}
