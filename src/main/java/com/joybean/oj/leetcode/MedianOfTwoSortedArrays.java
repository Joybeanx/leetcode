package com.joybean.oj.leetcode;

import com.sun.nio.sctp.IllegalUnbindException;

import java.util.ArrayList;
import java.util.List;

/**
 * Median of Two Sorted Arrays
 * <p>There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>Example1:
 * <pre class="code">
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * </pre>
 * <p>Example2:
 * <pre class="code">
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * </pre>
 *
 * @author Jobean
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
}
