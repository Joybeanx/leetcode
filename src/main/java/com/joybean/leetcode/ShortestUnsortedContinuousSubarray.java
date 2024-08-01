package com.joybean.leetcode;

/**
 *
 * <a href="https://leetcode.com/problems/shortest-unsorted-continuous-subarray/">Shortest Unsorted Continuous Subarray</a>
 *
 * @author Joybean
 */
public class ShortestUnsortedContinuousSubarray {
    /**
     * <a href="https://leetcode.com/problems/shortest-unsorted-continuous-subarray/solutions/103057/java-o-n-time-o-1-space/">Straight forward solution(by haruhiku)</a>
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray1(int[] nums) {
        //From left to right, find the potential start s where nums[s+1]<nums[s]
        int n = nums.length;
        int start = 1;
        while (start < n && nums[start] >= nums[start - 1]) {
            start++;
        }
        if (start == n) {
            return 0;
        }
        //From right to left, find the potential end e where nums[e]<nums[e-1]
        int end = n - 1;
        while (end - 1 >= 0 && nums[end] >= nums[end - 1]) {
            end--;
        }
        if (end < start) {
            return start - end + 1;
        }
        //Find the min value and max value of the elements between start and end, compare them with the numbers from
        // 0 to s and e to length -1. Update the start and end.
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int k = start; k <= end; k++) {
            max = Math.max(nums[k], max);
            min = Math.min(nums[k], min);
        }

        while (start >= 1 && min < nums[start - 1]) {
            start--;
            max = Math.max(nums[start], max);
        }
        while (end < n - 1 && max > nums[end + 1]) {
            end++;
        }
        return end - start + 1;
    }

    /**
     * <a href="https://leetcode.com/problems/shortest-unsorted-continuous-subarray/solutions/103057/java-o-n-time-o-1-space/">Find the most right element having greater elements on the left side and the most left element having smaller elements on the right side(by tonyhe89)</a>
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray2(int[] nums) {
        return 0;
    }
}
