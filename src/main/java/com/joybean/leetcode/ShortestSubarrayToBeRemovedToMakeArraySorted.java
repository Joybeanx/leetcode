package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/">Shortest Subarray to be
 * Removed to Make Array Sorted</a>
 *
 * @author Joybean
 */
public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    /**
     * <a href="https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/solutions/830480/c-o-n-sliding-window-explanation-with-illustrations/">Sliding window</a>
     *
     * @param arr
     * @return
     */
    public static int findLengthOfShortestSubarray1(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == n - 1) {
            return 0;
        }
        while (right - 1 >= 0 && arr[right] >= arr[right - 1]) {
            right--;
        }
        int ans = Math.min(n - left - 1, right);
        int i = 0;
        int j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                ans = Math.min(j - i - 1, ans);
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    /**
     * Two pointers
     * <p>
     * TODO
     *
     * @param arr
     * @return
     */
    public static int findLengthOfShortestSubarray2(int[] arr) {
        return 0;
    }
}
