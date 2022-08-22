package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/">Merge Sorted Array</a>
 *
 * @author Joybean
 */
public class MergeSortedArray {
    /**
     * Straight forward merge sort
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[nums1.length];
        int i = 0;
        int j = 0;
        int cur = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[cur++] = nums1[i++];
            } else {
                merged[cur++] = nums2[j++];
            }
        }
        while (i < m) {
            merged[cur++] = nums1[i++];
        }
        while (j < n) {
            merged[cur++] = nums2[j++];
        }
        for (int k = 0; k < merged.length; k++) {
            nums1[k] = merged[k];
        }
    }

    /**
     * In-place merge sort
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
